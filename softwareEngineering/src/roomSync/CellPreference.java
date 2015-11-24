package roomSync;

public class CellPreference extends Cell
{
	public CellPreference(Person person)
	{
		super(person);
	}
	
	public CellPreference(Person person, CState status)
	{
		super(person,status);
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
