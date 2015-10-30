import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

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
	//Function to make Persons, input can look like "FirstName LastName|Student ID|Y,N,Y.." , Name | Student ID | Attributes in the right order
	public void makePersons()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the file pathname for all Persons and their Attributes: ");
		String filepathname = in.nextLine();
		System.out.println();
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
				
				personList.add(new Person(cmdParts[0], cmdParts[1], cmdParts[2]));
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
	private void printPersons()
	{
		System.out.println("List of all Persons:");
		for(Person person: personList)
			System.out.println(person.toString());
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
}
