package roomSync;

public class CStateProposalMade implements CState
{
	String state;
	public CStateProposalMade()
	{
		state = "(P)";
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
