package roomSync;

public class CStateRejected implements CState
{
	String state;
	public CStateRejected()
	{
		state = "(R)";
	}
	
	public CState getStatus()
	{
		return this;
	}
	
	public String getString()
	{
		return state;
	}
	
}
