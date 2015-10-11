import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Office
{
	//singleton Office, full control over Person
	private static Office office = new Office();
	private ArrayList<Person> personList;
	private Office()
	{
		personList = new ArrayList<>();
	}	
	public static Office getOffice()
	{
		return office;
	}
	//Function to make Persons, input can look like "FirstName LastName|Y,N,.." , Name | Attributes in the right order
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
				
				personList.add(new Person(cmdParts[0], cmdParts[1]));
			}
			printPersons();
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
}
