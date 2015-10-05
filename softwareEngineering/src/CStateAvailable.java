
public class CStateAvailable implements CState
{
	String state = "(N)";
	public CStateAvailable()
	{
		state = "(N)";
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
