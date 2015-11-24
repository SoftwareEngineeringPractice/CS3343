package roomSync;

public class CStateAccepted implements CState
{
	String state;
	public CStateAccepted()
	{
		state = "(A)";
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
