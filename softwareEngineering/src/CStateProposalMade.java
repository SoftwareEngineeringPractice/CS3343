
public class CStateProposalMade implements CState {

	public String getString()
	{
		return "(P)";
	}
	
	public CState getStatus()
	{
		return this;
	}
	
}
