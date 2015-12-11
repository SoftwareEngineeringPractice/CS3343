package roomSync;
import java.util.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentOffice
{
	//singleton Office, full control over Person
	private static StudentOffice office = new StudentOffice();
	private ArrayList<Person> personList;
	private StudentOffice()
	{
		personList = new ArrayList<>();
	}	
	public static StudentOffice getOffice()
	{
		return office;
	}
	
	
	public void removeHallOccupants(Person p){
		personList.remove(p);
	}
	
	
	//Function to make Persons, input can look like "FirstName LastName|Student ID|Sex|Y,N,Y.." , Name | Student ID | Sex | Attributes in the right order
	public void makePersons() throws IOException
	{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please input the file pathname for all Persons and their Attributes: ");
		String filepathname = in.readLine();
		System.out.println();
		BufferedReader inFile = null;
		try
		{
			inFile = new BufferedReader(new FileReader(filepathname));;
		  
				
			while (inFile.ready())
			{
				String cmdLine = inFile.readLine().trim();
				//Blank lines exist in data file as separators.  Skip them.
				if (cmdLine.equals("")) continue;  
				
				//split the words in actionLine => create an array of word strings
				String[] cmdParts = cmdLine.split("\\|");
				String atr = "NNN";
				if(cmdParts.length == 4){
					atr = cmdParts[3];
				}
				personList.add(new Person(cmdParts[0], cmdParts[1], cmdParts[2], atr));
			}
			
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error! File not found!");
			throw new IOException();
		}
		finally
		{
			if(inFile != null)
			{
				inFile.close();			
			}
		}
	}
	
	public void makePersons(String filepathname)
	{
		Scanner in = new Scanner(System.in);
		Scanner inFile = null;
		try
		{
			inFile = new Scanner(new File(filepathname));
				
			while (inFile.hasNext())
			{
				String cmdLine = inFile.nextLine().trim();
				//Blank lines exist in data file as separators.  Skip them.
				if (cmdLine.equals("")) continue;  
				
				//split the words in actionLine => create an array of word strings
				String[] cmdParts = cmdLine.split("\\|");
				
				personList.add(new Person(cmdParts[0], cmdParts[1], cmdParts[2], cmdParts[3]));
			}
			
			
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Error! File not found!");
		}
		finally
		{
			if(inFile != null)
			{
				inFile.close();			
			}
			in.close();
		}
	}
	
	
	//print all people
	public void printPersons()
	{
		System.out.print("List of all Persons:\n");
		for(Person person: personList)
			System.out.print(person.toString());
	}
	//return list of Persons in the program
	public ArrayList<Person> getPersonList()
	{
		return personList;
	}
	//make the preference List for Person p
	public void makePreferences(Person p)
	{
		p.makePreferenceList(personList);
	}
	public void makePreferences()
	{
		for(Person p: personList)
			p.makePreferenceList(personList);
	}
	public void makePreferences(ArrayList<Person> people)
	{
		// All preferences will be made within the set people
		for(Person p: people)
			p.makePreferenceList(people);
	}
	
	//print preferences
	public void printPreferenceList()
	{
		for(Person p: personList)
		{
			System.out.println("Preference for " + p.getName() + " - ");
			p.printPreference();
		}
	}
	
	public void clearPersonList(){
		personList.clear();
	}
	
	public void addPerson(Person p)
	{
		personList.add(p);
	}
	
	public void removePerson(Person p)
	{
		personList.remove(p);
	}
	
	public String getAttri(Person p)
	{
		return personList.get(personList.indexOf(p)).getAttri();
	}
}
