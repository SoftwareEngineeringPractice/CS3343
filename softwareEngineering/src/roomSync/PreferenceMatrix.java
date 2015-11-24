package roomSync;
/* Steps, Pseudo code : https://www.youtube.com/watch?v=5QLxAp8mRKo

matrix[][] ~~

a: b, d, f, c, e 
b: d, e, f, a, c 
c: d, e, f, a, b 
d: f, c, a, e, b 
e: f, c, d, b, a 
f: a, b, d, c, e

The first row can be interpreted as: 
b is a's first preference, his second preference is d and so on...


Each element in this matrix belongs to the class Cell.
Cell is an abstract class, extended by 'CellSubject' & 'CellPreference'
The left most column are instances of CellSubject (header cell)
The rest belong CellPreference.
Each cell has a status [E.g. null, accepted, rejected and proposal made]
CellSubjects can't have their statuses changed.

After completing all 3 stages we'll have a matrix with each row having only 1 non rejected Person.

*/

import java.awt.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PreferenceMatrix
{
	// Important! Domain: People eligible for residence. Don't include people who are not eligible
	//(e.g. arrived late, where fcfs is implemented) 
	//TODO: have to check that the people eligible for residence are only in this list.	
	private Cell[][] matrix;
	//noOfPeople = Number of people accepted in the residence
	private int noOfPeople;
	
	private ArrayList<Pair> pair = new ArrayList<>();
	private ArrayList<Person> single = new ArrayList<>(); 
	
	
	public ArrayList<Pair> getPaired()
	{
		return this.pair;
	}
	
	public ArrayList<Person> getUnPaired()
	{
		return this.single;
	}
	
	
	
	//added for testing purposes
	public PreferenceMatrix(Cell[][] c)
	{
		matrix = c;
	}
	
	public PreferenceMatrix(ArrayList<Person> people)
	{
		this.noOfPeople = people.size();
		matrix = new Cell[noOfPeople][noOfPeople];
		for(int i = 0; i < noOfPeople; i++)
		{
			//Left most column, their status can't be changed
			
			matrix[i][0] = new CellSubject(people.get(i));
			ArrayList<ArrayList<Person>> preferenceSet = people.get(i).getPreferenceList();
			//ArrayList<Person> preferences = people.get(i).getPreferenceList();
			ArrayList<Person> preferences = new ArrayList<>();
			
			for (ArrayList<Person> set:preferenceSet )
			{
				//long seed = System.nanoTime();
				//Collections.shuffle(set, new Random(seed));
				Collections.shuffle(set);
				preferences.addAll(set);
			}
			
			//rest, if matrix, their status can be changed
			//TODO Exception handler required, If n guys are eligible for residence, the preference list for P1 should contain (P2...PN) in any order and no repetition.
			//The first guy in the preference List is the most preferred.
			
			for(int j = 0; j < preferences.size(); j++)
			{
				matrix[i][j+1] = new CellPreference(preferences.get(j));
			}
		}
	}
	
	public void displayMatrix()
	{
		for(int i = 0; i < noOfPeople; i++ )
		{
			// display the row's first element (header)
			System.out.print(matrix[i][0].getName()+": ");
			for(int j = 1; j < noOfPeople; j++)
			{
				if(!(matrix[i][j].getStatus() instanceof CStateRejected) )
					//display rest of the row. (preference list along with status string)
					System.out.print(matrix[i][j].getName()+matrix[i][j].getStatusString() + ", ");
			}
			System.out.println();
		}
	}
	
	public void displayFinalResult()
	{
		for(int i=0; i<noOfPeople; i++)
		{
			//TODO: Error
			System.out.println(matrix[i][0].getName() + " - " + getFirstNonRejectedPerson(matrix[i][0].getPerson()).getName());
		}
	}
	//Suppose a's preference list is b, d, c, f - findCell(a,c) would return the third cell.
	//TODO: Exception handler required, at least for this algorithm, this function should never return null. If it does, it means there's someone who is eligible for residence but is missing in the subject's preference list 
	public Cell findCell(Person subject,Person preferred)
	{
		for(int i = 0; i < noOfPeople; i++)
		{
			if(subject.equals(matrix[i][0].getPerson()))
			{
				for(int j = 1; j < noOfPeople; j++)
				{
					if(preferred.equals(matrix[i][j].getPerson()))
					{
						return matrix[i][j];
					}
				}
			}
		}
		return null;
	}
	
	
	//For [p1 in p2's preference list] & [p2 in p1's preference list] change the status to rejected.
	public void removeSymmetrically(Person p1,Person p2)
	{
		// p1 and p2 should not be equal
		Cell cell1,cell2;
		cell1 = findCell(p1,p2);
		cell2 = findCell(p2,p1);
		cell1.reject();
		cell2.reject();
	}
	
	//The subject proposes his most preferred and available Person
	public void proposeToFav(int rowIndex)
	{
		Person proposer = matrix[rowIndex][0].getPerson();
		for(int j = 1; j < noOfPeople; j++)
		{
			Cell proposalReceiver = matrix[rowIndex][j];
			if(proposalReceiver.getStatus() instanceof CStateAvailable)
			{
				proposalReceiver.proposalMade();
				Person receiver = proposalReceiver.getPerson();
				reactToProposal(receiver,proposer);
				break;
			}
				
		}
	}
	

	public int getMatrixRowIndexForPerson(Person p1)
	{
		for(int i = 0; i<noOfPeople; i++)
		{
			if(p1.equals(matrix[i][0].getPerson()))
			{
				return i;
			}
		}
		return noOfPeople;
	}
	
	public void Stage1()
	{

		for(int i = 0; i < noOfPeople; i++){
			proposeToFav(i);
		}
	}
	
	public void Stage2()
	{
		
		for(int i = 0; i < noOfPeople; i++)
		{
			boolean postAcceptanceRegion = false;
			for(int j = 1; j < noOfPeople; j++)
			{
				if(postAcceptanceRegion)
				{
					Person p1 = matrix[i][j].getPerson();
					Person p2 = matrix[i][0].getPerson();
					removeSymmetrically(p1,p2);
				}
				else if(!postAcceptanceRegion && matrix[i][j].getStatus() instanceof CStateAccepted)
				{
					postAcceptanceRegion = true;
				}
			}
		}
	}
	
	public void Stage3()
	{
		
		//TODO very important, check if any row has only one Person, if yes -> symmetrically remove both and consider them a pair
		
		
		for(int i = 0; i < noOfPeople; i++ )
		{
			//Has more than one choice in row
			while(availableChoicesInRow(i) > 1)
			{
				formCycle(i);
			}
		}
		
		
		// Create object that stores the pairs
		for(int i = 0; i < noOfPeople; i++)
		{
			// For Double room
			if(availableChoicesInRow(i) == 1)
			{
				Person left  = matrix[i][0].getPerson();
				Person right = getFirstNonRejectedPerson(left);
				Pair roomates = new Pair(left,right);
				// check if this pair is already not in the list
				if(!contains(new Pair(right,left)))
				{
					//System.out.println(roomates.getLeft() + "" + roomates.getRight());
					pair.add(roomates);
				}
			}
			else if(availableChoicesInRow(i) == 0)
			{
				Person singlePeople = matrix[i][0].getPerson();
				single.add(singlePeople);
			}
			
			
		}
		
		
	}
	
	public void formCycle(int rowIndex)
	{
		//cycle doesn't contain first player
		//ArrayList<Person> cycle = new ArrayList<>();
		Person startPlayer = matrix[rowIndex][0].getPerson();
		boolean cycleComplete = false;
		Person currentPlayer = startPlayer; 
		
		
		
		
		ArrayList<Person> firstRow  = new ArrayList<Person>();
		ArrayList<Person> secondRow = new ArrayList<Person>();
		
		firstRow.add(startPlayer);
		
		
		while(!cycleComplete)
		{
			
			Person secondPreference;
			if( availableChoicesInRow(getMatrixRowIndexForPerson(currentPlayer)) > 1)
			{
				secondPreference = getSecondAvailablePreference(currentPlayer);
			}
			else
			{
				secondPreference = getFirstNonRejectedPerson(currentPlayer);
			}
			// If a row has more than one copy of the same person - stop operation, start rejecting
			if(secondRow.contains(secondPreference))
			{
				secondRow.add(secondPreference);
				break;
			}
			else
			{
				secondRow.add(secondPreference);
			}
			
			currentPlayer = getLastAvailablePreference(secondPreference);
			
			if(firstRow.contains(currentPlayer))
			{
				firstRow.add(currentPlayer);
				break;
			}
			else
			{
				firstRow.add(currentPlayer);
			}
					
			
		}
		
		for(int j = 0 ; j < secondRow.size(); j++)
		{
			int i = j + 1;
			if(i < firstRow.size())
			{
				removeSymmetrically(firstRow.get(i),secondRow.get(j));
			}
		}
		
	}
	
	public Person getSecondAvailablePreference(Person p)
	{
		//System.out.print(p);
		int row = getMatrixRowIndexForPerson(p);
		int count = 0;
		for(int j = 1; j < noOfPeople; j++)
		{
			if(!(matrix[row][j].getStatus() instanceof CStateRejected) )
			{
				count++;
			}
			if(count==2)
			{
				return matrix[row][j].getPerson();
			}
		}
		return null;
	}
	
	public Person getLastAvailablePreference(Person p)
	{
		//System.out.println(p);
		int row = getMatrixRowIndexForPerson(p);
		for(int j = noOfPeople-1; j >= 0; j--)
		{
			if(!(matrix[row][j].getStatus() instanceof CStateRejected) )
			{
				return matrix[row][j].getPerson();
			}
		}
		return null;
	}
	
	public Person getFirstNonRejectedPerson(Person p)
	{
		int row = getMatrixRowIndexForPerson(p);
		int count = 0;
		for(int j = 1; j < noOfPeople; j++)
		{
			if(!(matrix[row][j].getStatus() instanceof CStateRejected) )
			{
				count++;
			}
			if(count==1)
			{
				return matrix[row][j].getPerson();
			}
		}
		return null;
		
	}
	
	public int availableChoicesInRow(int rowIndex)
	{
		int count = 0;
		for (int j = 1; j < noOfPeople; j++)
		{
			if(!(matrix[rowIndex][j].getStatus() instanceof CStateRejected))
			{
				count++;
			}
		}
		return count;
	}
	
	public void reactToProposal(Person receiver,Person proposer)
	{
		int rowIndex = getMatrixRowIndexForPerson(receiver);
		for(int j = 1; j < noOfPeople; j++)
		{
			Cell reactorCell = matrix[rowIndex][j];
			if(proposer.equals(reactorCell.getPerson()))
			{
				reactorCell.accept();
				clearExcessiveAcceptance(rowIndex);
			}
		}
		
	}
	
	public void clearExcessiveAcceptance(int rowIndex)
	{
		int count = 0;
		for(int j = 1; j < noOfPeople; j++ )
		{
			if(matrix[rowIndex][j].getStatus() instanceof CStateAccepted)
			{
				count++;
			}
			// More than one proposal accepted
			if(count > 1)
			{
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
	public boolean contains(Pair check)
	{
		for(Pair checkWith: pair)
		{
			if((check.getRight().equals(checkWith.getRight())) && (check.getLeft().equals(checkWith.getLeft())))
				return true;
		}
    	return false;
	}
	
	public Cell[][] getMatrix()
	{
		return matrix;
	}
	
}
