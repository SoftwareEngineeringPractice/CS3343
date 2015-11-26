package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class ShrankhlaTest1 {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	
	
	
	
	//@Test
	public void getresultSharankhla(){
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/3sh.txt");
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		
		
		ArrayList<Pair> pairs = office.pairMale();
		for(Pair pa : pairs)
		{
			System.out.println(pa);
		}
		
		//check - works properly?
		
		//---------------
		///office.pairMale();
		//---------------
		
		
		//----
		
		/*ArrayList<Pair> pairs = office.pairMale();
		for(Pair pa : pairs)
		{
			System.out.println(pa);
		}*/
		
		/*studentOfficeInstance.makePreferences(office.getEligibleMaleList());
		p = new PreferenceMatrix(office.getEligibleMaleList());
		System.out.println("Input ");
		p.displayMatrix();
		
		System.out.println("Stage1");
		p.Stage1();
		p.displayMatrix();*/
	
		
		
		
		/*System.out.println("Stage2");
		p.Stage1();
		p.Stage2();
		p.displayMatrix();
		
		System.out.println("Stage3");
		p.Stage1();
		p.Stage2();
		p.Stage3();
		p.displayMatrix();
		
		*/
		
		/*p.Stage1();
		p.Stage2();
		p.Stage3();*/
		//without stage 1,2,3 --> p.displayMatrix() --> initial Input (test ops on this)
		
		//+ p.stage1() --> expected resut (Stage1 testing)
		//------
		
	}
	
	
	@Test
	public void testStage1_3SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1001","M","YYN");
		Person B = new Person("B","2001","M","NYN");
		Person C = new Person("C","3001","M","NNN");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","NYY");
		Person F = new Person("F","6001","M","NYN");
		Person G = new Person("G","7001","M","YNY");
		
		
		
		
		
		

		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D), new CellPreference(B), new CellPreference(G), new CellPreference(E), new CellPreference(C),new CellPreference(F)},
				  { new CellSubject(B), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(F), new CellPreference(D),new CellPreference(G) },
				  { new CellSubject(C), new CellPreference(F), new CellPreference(B), new CellPreference(G), new CellPreference(A), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(D), new CellPreference(A), new CellPreference(G), new CellPreference(E), new CellPreference(B), new CellPreference(C),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(B), new CellPreference(A), new CellPreference(C), new CellPreference(F),new CellPreference(G)},
				  { new CellSubject(F), new CellPreference(C), new CellPreference(B), new CellPreference(A), new CellPreference(E), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(G), new CellPreference(D), new CellPreference(F), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E)},
				 
		
		
		
		};
		
		//Declare the 3 additional states required -- Remains unchanged
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		//you will make this matrix once you see the output from p.displayMatrix() <-- actual output (cheating) [de-comment p.displayMatrix()]
		//Don't make the matrix yet. Look at the actual output!
		
		/* * Interpreting the actual output that's displayed on the console
		 * 
		 * 1) (N) --> CStateAvailable (No changes required)
		 * 2) (A) --> CStateAccepted  (I have done constructor overloading [look below], when you make the expected array[the one below] add "accepted" as the second argument)
		 * 3) (P) --> CStateProposalMade (I have done constructor overloading [look below], when you make the expected array[the one below] add "proposalMade" as the second argument)
		 * 4) (R) --> CStateRejected (I have done constructor overloading [look below], when you make the expected array[the one below] add "rejected" as the second argument)
		 *
		 *
		 *accepted, proposalMade and rejected are define above*/
		 
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(C,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F,accepted), new CellPreference(D,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(C), new CellPreference(F,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(D,rejected)},
				  { new CellSubject(D), new CellPreference(A,accepted), new CellPreference(G,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(D,rejected), new CellPreference(B,accepted), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(F), new CellPreference(C,accepted), new CellPreference(B,proposalMade), new CellPreference(A,rejected), new CellPreference(E,rejected), new CellPreference(E,proposalMade),new CellPreference(D,rejected)},
				  { new CellSubject(G), new CellPreference(D,accepted), new CellPreference(F,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected)},
				  
		
		
		
		};
		System.out.println("======\nThis is SHRANKHLA's test [Stage1_3]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		System.out.println("SHRANKHLA Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("SHRANKHLA Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	

	@Test
	public void testStage2_3SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1001","M","YYN");
		Person B = new Person("B","2001","M","NYN");
		Person C = new Person("C","3001","M","NNN");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","NYY");
		Person F = new Person("F","6001","M","NYN");
		Person G = new Person("G","7001","M","YNY");
		
		
		
		
		
		

		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D), new CellPreference(B), new CellPreference(G), new CellPreference(E), new CellPreference(C),new CellPreference(F)},
				  { new CellSubject(B), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(F), new CellPreference(D),new CellPreference(G) },
				  { new CellSubject(C), new CellPreference(F), new CellPreference(B), new CellPreference(G), new CellPreference(A), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(D), new CellPreference(A), new CellPreference(G), new CellPreference(E), new CellPreference(B), new CellPreference(C),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(B), new CellPreference(A), new CellPreference(C), new CellPreference(F),new CellPreference(G)},
				  { new CellSubject(F), new CellPreference(C), new CellPreference(B), new CellPreference(A), new CellPreference(E), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(G), new CellPreference(D), new CellPreference(F), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E)},
				 
		
		
		
		};
		
		//Declare the 3 additional states required -- Remains unchanged
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		//you will make this matrix once you see the output from p.displayMatrix() <-- actual output (cheating) [de-comment p.displayMatrix()]
		//Don't make the matrix yet. Look at the actual output!
		
		/* * Interpreting the actual output that's displayed on the console
		 * 
		 * 1) (N) --> CStateAvailable (No changes required)
		 * 2) (A) --> CStateAccepted  (I have done constructor overloading [look below], when you make the expected array[the one below] add "accepted" as the second argument)
		 * 3) (P) --> CStateProposalMade (I have done constructor overloading [look below], when you make the expected array[the one below] add "proposalMade" as the second argument)
		 * 4) (R) --> CStateRejected (I have done constructor overloading [look below], when you make the expected array[the one below] add "rejected" as the second argument)
		 *
		 *
		 *accepted, proposalMade and rejected are define above*/
		 
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(C,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(C), new CellPreference(F,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(D,rejected)},
				  { new CellSubject(D), new CellPreference(A,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(D,rejected), new CellPreference(B,accepted), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(F), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected), new CellPreference(E,proposalMade),new CellPreference(D,rejected)},
				  { new CellSubject(G), new CellPreference(D,rejected), new CellPreference(F,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected)},
				  
		
		
		
		};
		System.out.println("======\nThis is SHRANKHLA's test [Stage2_3]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		System.out.println("SHRANKHLA Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("SHRANKHLA Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	
	
	@Test
	public void testStage3_3SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1001","M","YYN");
		Person B = new Person("B","2001","M","NYN");
		Person C = new Person("C","3001","M","NNN");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","NYY");
		Person F = new Person("F","6001","M","NYN");
		Person G = new Person("G","7001","M","YNY");
		
		
		
		
		
		

		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D), new CellPreference(B), new CellPreference(G), new CellPreference(E), new CellPreference(C),new CellPreference(F)},
				  { new CellSubject(B), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(F), new CellPreference(D),new CellPreference(G) },
				  { new CellSubject(C), new CellPreference(F), new CellPreference(B), new CellPreference(G), new CellPreference(A), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(D), new CellPreference(A), new CellPreference(G), new CellPreference(E), new CellPreference(B), new CellPreference(C),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(B), new CellPreference(A), new CellPreference(C), new CellPreference(F),new CellPreference(G)},
				  { new CellSubject(F), new CellPreference(C), new CellPreference(B), new CellPreference(A), new CellPreference(E), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(G), new CellPreference(D), new CellPreference(F), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E)},
				 
		
		
		
		};
		
		//Declare the 3 additional states required -- Remains unchanged
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		//you will make this matrix once you see the output from p.displayMatrix() <-- actual output (cheating) [de-comment p.displayMatrix()]
		//Don't make the matrix yet. Look at the actual output!
		
		/* * Interpreting the actual output that's displayed on the console
		 * 
		 * 1) (N) --> CStateAvailable (No changes required)
		 * 2) (A) --> CStateAccepted  (I have done constructor overloading [look below], when you make the expected array[the one below] add "accepted" as the second argument)
		 * 3) (P) --> CStateProposalMade (I have done constructor overloading [look below], when you make the expected array[the one below] add "proposalMade" as the second argument)
		 * 4) (R) --> CStateRejected (I have done constructor overloading [look below], when you make the expected array[the one below] add "rejected" as the second argument)
		 *
		 *
		 *accepted, proposalMade and rejected are define above*/
		 
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D,proposalMade), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(C), new CellPreference(F,proposalMade), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(D,rejected)},
				  { new CellSubject(D), new CellPreference(A,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(D,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(F), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected), new CellPreference(E,proposalMade),new CellPreference(D,rejected)},
				  { new CellSubject(G), new CellPreference(D,rejected), new CellPreference(F,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected)},
				  
		
		
		
		};
		System.out.println("======\nThis is SHRANKHLA's test [Stage3_3]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		System.out.println("SHRANKHLA Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("SHRANKHLA Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}


	
	
	

	
	
}