
import java.util.*;

public class Person
{
	//name of Person
	private String name;
	private String studentID;
	//order for this preference list matters.
	private ArrayList<ArrayList<Person>> preferenceList= new ArrayList<>();
	//Person's attribute list
	private AttributeList attributes = new AttributeList();
	
	public Person(String name, String studentID, String v)
	{
		this.name = name;
		this.studentID = studentID;
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
	public String getID() 
	{
		return studentID;
	}
	//ArrayList of ArrayList of Person, this Person's Preference List based on the distance between him and someone else
	//Return preference list and make preference list
	public ArrayList<ArrayList<Person>> makePreferenceList(ArrayList<Person> personList)
	{
		preferenceList.clear();
		int noOfPreferenceSets = attributes.getNoOfAttributes();
		
		for(int i = 0; i < noOfPreferenceSets; i++)
		{
			ArrayList<Person> preferenceSet = new ArrayList<>();
			preferenceList.add(preferenceSet);
		}
		
		for(Person p: personList)
		{
			if(!this.equals(p))
			{
				int distance = this.distance(p);
				preferenceList.get(distance).add(p);
			}
			
		}
		
		return preferenceList;
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
	//check if this equals to p
	@Override
	public boolean equals(Object p1)
	{
		Person p = (Person) p1;
		if(p.getID().equals(this.studentID))
			return true;
		return false;
	}
	//printperferenceSet()
	public void printPreferenceSet(int i)
	{
		System.out.print("Set " + i);
		ArrayList<Person> preferenceSet = preferenceList.get(i);
		for(Person p: preferenceSet)
		{
			System.out.print(" " + p.getName()); 
		}
		System.out.println();
	}
	public void printPreference()
	{
		for(int i = 0; i < attributes.getNoOfAttributes(); i++)
		{
			printPreferenceSet(i);
		}
	}
}
