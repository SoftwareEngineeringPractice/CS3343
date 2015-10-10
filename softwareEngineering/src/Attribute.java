
public class Attribute
{
	private String name;
	private boolean value;
	public Attribute(String name, boolean value)
	{
		this.name = name;
		this.value = value;
	}
	public boolean getValue()
	{
		return value;
	}
	public void setValue(boolean value)
	{
		this.value = value;
	}
	public String getName()
	{
		return name;
	}
	
}
