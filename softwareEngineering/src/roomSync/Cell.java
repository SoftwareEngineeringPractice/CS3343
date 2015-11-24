package roomSync;

public abstract class Cell
{

	private Person person;
	private CState status = new CStateAvailable();
	
	public Cell(Person person)
	{
		this.person = person;
	}
	
	public Cell(Person person, CState status)
	{
		this.person = person;
		this.status = status;
	}
	
	public String getName()
	{
		return this.person.getName();
	}
	
	public Person getPerson()
	{
		return this.person;
	}
	
    public void setStatus(CState state)
    {
    	this.status = state; 
    }
	
	public abstract void reject();

	public abstract void accept();
	
	public abstract void proposalMade();

	
    public CState getStatus()
    {
    	return this.status;
    }
    
    public String getStatusString()
    {
    	return this.status.getString();
    }
}
