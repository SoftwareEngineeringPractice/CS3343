

import java.util.ArrayList;


public class PreferenceMatrix {

	private Cell[][] matrix;
	private int noOfPeople;
	
	
	public PreferenceMatrix(ArrayList<Person> people){
		
		this.noOfPeople = people.size();
		matrix = new Cell[noOfPeople][noOfPeople];
		
		for(int i = 0; i < noOfPeople; i++){
			
			matrix[i][0] = new Cell(people.get(i));
			ArrayList<Person> preferences = people.get(i).getPreferenceList();
			
			for(int j = 0; j < preferences.size(); j++){
				matrix[i][j+1] = new Cell(preferences.get(j));
			}
			
		}
		
		
	}
	
	public void displayMatrix(){
		
		for(int i = 0; i < noOfPeople; i++ ){
			System.out.print(matrix[i][0].getName()+": ");
			for(int j = 1; j <noOfPeople; j++){
				System.out.print(matrix[i][j].getName()+matrix[i][j].getStatusString()+", ");
			}
			System.out.println();
		}
	}
	
	
	public Cell findCell(Person subject,Person preferred){
		for(int i = 0; i < noOfPeople; i++){
			if(subject.equals(matrix[i][0].getPerson())){
				for(int j = 1; j < noOfPeople; j++){
					if(preferred.equals( matrix[i][j].getPerson() )){
						return matrix[i][j];
						
					}
				}
			}
		}
		return null;
	}
	
	
	
	public void removeSymmetrically(Person p1,Person p2){
		// p1 and p2 should not be equal
		Cell cell1,cell2;
		cell1 = findCell(p1,p2);
		cell2 = findCell(p2,p1);
		cell1.reject();
		cell2.reject();
	}
	
	public void proposeToFav(int rowIndex){
		Person proposer = matrix[rowIndex][0].getPerson();
		for(int j=1; j<noOfPeople; j++){
			Cell proposalReceiver = matrix[rowIndex][j];
			if(proposalReceiver.getStatus()==null){
				proposalReceiver.proposalMade();
				Person receiver = proposalReceiver.getPerson();
				reactToProposal(receiver,proposer);
				break;
			}
				
		}
	}
	
	//return number of people if not found
	public int getMatrixRowIndexForPerson(Person p1){
		for(int i = 0; i<noOfPeople; i++){
			if(p1.equals(matrix[i][0].getPerson())){
				return i;
			}
		}
		return noOfPeople;
	}
	
	public void Stage1(){

		for(int i = 0; i < noOfPeople; i++){
			proposeToFav(i);
		}
		
	}
	
	public void Stage2(){
		
		for(int i = 0; i < noOfPeople; i++){
			boolean postAcceptanceRegion = false;
			for(int j = 1; j < noOfPeople; j++){
				if(postAcceptanceRegion){
					Person p1 = matrix[i][j].getPerson();
					Person p2 = matrix[i][0].getPerson();
					removeSymmetrically(p1,p2);
				}
				else if(!postAcceptanceRegion && matrix[i][j].getStatus() instanceof CStateAccepted){
					postAcceptanceRegion = true;
				}
			}
		}
	}
	
	public void Stage3(){
		for(int i = 0; i < noOfPeople; i++ ){
			//Has more than one choice in row
			while(availableChoicesInRow(i) > 1){
				formCycle(i);
			}
			
		}
		
	}
	
	public void formCycle(int rowIndex){
		//cycle doesnt contain first player
		ArrayList<Person> cycle = new ArrayList<>();
		Person startPlayer = matrix[rowIndex][0].getPerson();
		boolean cycleComplete = false;
		Person currentPlayer = startPlayer; 
		
		while(!cycleComplete){
			Person secondPreference =  getSecondAvailablePreference(currentPlayer);
			currentPlayer           =  getLastAvailablePreference(secondPreference);
			
			cycle.add(secondPreference);
			cycle.add(currentPlayer);
			
			
			if(currentPlayer.equals(startPlayer)){
				cycleComplete = true;
			}
		}
		
		for(int i = 0; i < cycle.size(); i=i+2){
			removeSymmetrically(cycle.get(i),cycle.get(i+1));
		}
		
	}
	
	public Person getSecondAvailablePreference(Person p){
		int row = getMatrixRowIndexForPerson(p);
		int count = 0;
		for(int j = 1; j < noOfPeople; j++){
			if(!(matrix[row][j].getStatus() instanceof CStateRejected) ){
				count++;
			}
			if(count==2){
				return matrix[row][j].getPerson();
			}
		}
		return null;
	}
	
	public Person getLastAvailablePreference(Person p){
		int row = getMatrixRowIndexForPerson(p);
		for(int j = noOfPeople-1; j >= 0; j--){
			if(!(matrix[row][j].getStatus() instanceof CStateRejected) ){
				return matrix[row][j].getPerson();
			}
		}
		return null;
	}
	
	public int availableChoicesInRow(int rowIndex){
		int count = 0;
		for (int j = 1; j < noOfPeople; j++){
			if(!(matrix[rowIndex][j].getStatus() instanceof CStateRejected) ){
				count++;
			}
		}
		return count;
	}

	public void reactToProposal(Person receiver,Person proposer){
		int rowIndex = getMatrixRowIndexForPerson(receiver);
		for(int j = 1; j < noOfPeople; j++ ){
			Cell reactorCell = matrix[rowIndex][j];
			if(proposer.equals(reactorCell.getPerson())){
				reactorCell.accept();
				clearExcessiveAcceptance(rowIndex);
			}
		}
		
	}
	
	public void clearExcessiveAcceptance(int rowIndex){
		int count = 0;
		for(int j = 1; j < noOfPeople; j++ ){
			if(matrix[rowIndex][j].getStatus() instanceof CStateAccepted){
				count++;
			}
			// More than one proposal accepted
			if(count > 1){
				//propose again (This guy would be the second preference)
				Person conflictProposer =  matrix[rowIndex][j].getPerson();
				Person confusedAccepter =  matrix[rowIndex][0].getPerson();
				removeSymmetrically(conflictProposer,confusedAccepter);
				//Now the rejected guy proposed again
				int proposerIndex = getMatrixRowIndexForPerson(conflictProposer);
				proposeToFav(proposerIndex);
			}
		}
	}
	
}
