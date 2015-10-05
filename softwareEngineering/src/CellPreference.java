
public class CellPreference extends Cell
{
	public CellPreference(Person person)
	{
		super(person);
	}

	public void reject()
	{
		super.setStatus(new CStateRejected());
	}
	
	public void accept()
	{
		super.setStatus(new CStateAccepted());
	}
	
	public void proposalMade()
	{
		super.setStatus(new CStateProposalMade());
	}
}
