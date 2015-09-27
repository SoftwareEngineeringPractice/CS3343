
public abstract class Cell {

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
	
    public void setStatus(CState state){
    	this.status = state; 
    }
	
	public abstract void reject();

	public abstract void accept();
	
	public abstract void proposalMade();

	
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
