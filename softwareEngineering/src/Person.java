
import java.util.*;

public class Person
{
	//name of Person
	private String name;
	//order for this preference list matters.
	private ArrayList<ArrayList<Person>> preferenceList= new ArrayList<>();
	//Person's attribute list
	private AttributeList attributes = new AttributeList();
	
	public Person(String name, String v)
	{
		this.name = name;
		//constructor calls a function to assign attributes to a person
		setAttributes(v);
	}
	//Input can look like "Y,N,...."
	//in the order of attributes
	public void setAttributes(String v)
	{
		String [] values = v.split(",");
		for(int i = 0; i < values.length; i++)
		{
			if(values[i].equalsIgnoreCase("Y"))
			{
				attributes.setAttributeValue(i , true);
			}
			else
			{
				attributes.setAttributeValue(i , false);
			}
		}
	}
	//returns the attribute list when needed
	public AttributeList getAttributes()
	{
		return attributes;
	}
	//returns name of Person
	public String getName()
	{
		return this.name;
	}
	/*
	public void addPreference(Person p)
	{
		//TODO exception handler required. the arg p:Person shouldn't be found in the ArrayList 'preferenceList' & shoudn't also equal itself (this:Person)    
		preferenceList.add(p);
	}
	
	public void addPreference(Person[] myPreference)
	{
		preferenceList.addAll(Arrays.asList(myPreference));
	}
	*/
	//ArrayList of ArrayList of Person, this Person's Preference List based on the distance between him and someone else
	//Return preference list and make preference list
	public ArrayList<ArrayList<Person>> makePreferenceList(ArrayList<Person> personList)
	{
		ArrayList<ArrayList<Person>> preferences = new ArrayList<>();
		ArrayList<Person> preference0 = new ArrayList<>();
		ArrayList<Person> preference1 = new ArrayList<>();
		ArrayList<Person> preference2 = new ArrayList<>();
		for(Person p: personList)
		{
			if(this.distance(p) == 0)
			{
				preference0.add(p);
			}
			else if(this.distance(p) == 1)
			{
				preference1.add(p);
			}
			else if(this.distance(p) == 2)
			{
				preference2.add(p);
			}
		}
		preferences.add(preference0);
		preferences.add(preference1);
		preferences.add(preference2);
		preferenceList = preferences;
		return preferences;
	}
	//return prefrenceList
	public ArrayList<ArrayList<Person>> getPreferenceList()
	{
		return this.preferenceList;
	}
	//calculate distance between this and Person p based on attributes
	public int distance(Person p)
	{
		int diff = 0;
		ArrayList<Attribute> thisAttribute = this.attributes.getList();
		for(Attribute thisAtt: thisAttribute)
		{
			ArrayList<Attribute> pAttribute = p.getAttributes().getList();
			for(Attribute pAtt: pAttribute)
			{
				if((thisAtt.getName().equals(pAtt.getName())) && (thisAtt.getValue() != pAtt.getValue()))
				{
					diff++;
				}
			}
		}
		return diff;
	}
	//Print person
	@Override
	public String toString()
	{
		String ret = name + "\n";
		ArrayList<Attribute> thisAttribute = this.attributes.getList();
		for(Attribute thisAtt: thisAttribute)
		{
			ret += "\t - " + thisAtt.getName() + "\t - " + thisAtt.getValue();
			ret += "\n";
			
		}
		return ret;
	}
}
