
public class Cell {

	private Person person;
	private CState status = null;
	
	public Cell(Person person){
		this.person = person;
	}
	
	public String getName(){
		return this.person.getName();
	}
	
	public Person getPerson(){
		return this.person;
	}
	
	public void reject(){
		status = new CStateRejected();
	}

	public void accept(){
		status = new CStateAccepted();
	}
	
	public void proposalMade(){
		status = new CStateProposalMade();
	}

	
    public CState getStatus(){
    	return this.status;
    }
    
    public String getStatusString(){
    	if(status == null)
    		return "(N)";
    	else
    		return this.status.getString();
    }
	
}
