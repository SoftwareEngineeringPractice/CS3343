
import java.util.ArrayList;
import java.util.Arrays;

public class Person
{
	
	private String name;
	// order for this preference list matters.
	private ArrayList<Person> preferenceList= new ArrayList<>();
	
	public Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public void addPreference(Person p)
	{
		//TODO exception handler required. the arg p:Person shouldn't be found in the ArrayList 'preferenceList' & shoudn't also equal itself (this:Person)    
		preferenceList.add(p);
	}
	
	public void addPreference(Person[] myPreference)
	{
		preferenceList.addAll(Arrays.asList(myPreference));
	}
	
	public ArrayList<Person> getPreferenceList()
	{
		return this.preferenceList;
	}
	
}
