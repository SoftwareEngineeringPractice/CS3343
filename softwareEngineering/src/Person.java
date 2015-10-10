
import java.util.*;

public class Person
{
	//name of Person
	private String name;
	//order for this preference list matters.
	private ArrayList<Person> preferenceList= new ArrayList<>();
	//Person's attribute list
	private AttributeList attributes = new AttributeList();
	
	public Person(String name, String v)
	{
		this.name = name;
		setAttributes(v);
	}
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
	
	public AttributeList getAttributes()
	{
		return attributes;
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
