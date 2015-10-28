import java.util.*;
public class AttributeList
{
	private ArrayList<Attribute> list= new ArrayList<>();
	public AttributeList()
	{
		//more attributes to be added her, if needed
		list.add(new Attribute("Smoker", false));
		list.add(new Attribute("Alcoholic", false));
		list.add(new Attribute("Night Owl", false));
	}
	//every Persons has his own attribute list
	public ArrayList<Attribute> getList()
	{
		return list;
	}
	//attribute order matters
	public void setAttributeValue(int number, boolean value)
	{
		list.get(number).setValue(value);
		return;
	}
	
	public int getNoOfAttributes()
	{
		return list.size()+1;
	}
}
