import java.util.*;
public class AttributeList
{
	private ArrayList<Attribute> list= new ArrayList<>();
	public AttributeList()
	{
		list.add(new Attribute("Smoker", false));
		list.add(new Attribute("Alcoholic", false));
	}
	
	public ArrayList<Attribute> getList()
	{
		return list;
	}
	public void setAttributeValue(int number, boolean value)
	{
		list.get(number).setValue(value);
		return;
	}
}
