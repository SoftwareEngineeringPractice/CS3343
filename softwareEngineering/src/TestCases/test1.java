package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class test1 {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	
	
	//@Test
	public void getresultPANDA(){
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/test1.txt");
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		
		//check - works properly?
		
		//---------------
		///office.pairMale();
		//---------------
		
		
		//----
		studentOfficeInstance.makePreferences(office.getEligibleMaleList());
		p = new PreferenceMatrix(office.getEligibleMaleList());
		System.out.println("Input ");
		p.displayMatrix();
		
		System.out.println("Stage1");
		p.Stage1();
		p.displayMatrix();
		
		
		/*p.Stage1();
		p.Stage2();
		p.Stage3();*/
		//without stage 1,2,3 --> p.displayMatrix() --> initial Input (test ops on this)
		
		//+ p.stage1() --> expected resut (Stage1 testing)
		//------
		
	}
	
	
	@Test
	public void getresultSharankhla(){
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/test1.txt");
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		
		//check - works properly?
		
		//---------------
		///office.pairMale();
		//---------------
		
		
		//----
		studentOfficeInstance.makePreferences(office.getEligibleMaleList());
		p = new PreferenceMatrix(office.getEligibleMaleList());
		System.out.println("Input ");
		p.displayMatrix();
		
		System.out.println("Stage1");
		p.Stage1();
		p.displayMatrix();
		
		
		/*p.Stage1();
		p.Stage2();
		p.Stage3();*/
		//without stage 1,2,3 --> p.displayMatrix() --> initial Input (test ops on this)
		
		//+ p.stage1() --> expected resut (Stage1 testing)
		//------
		
	}
	
	
	@Test
	public void getresultAman(){
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/test1.txt");
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		
		//check - works properly?
		
		//---------------
		///office.pairMale();
		//---------------
		
		
		//----
		studentOfficeInstance.makePreferences(office.getEligibleMaleList());
		p = new PreferenceMatrix(office.getEligibleMaleList());
		System.out.println("Input ");
		p.displayMatrix();
		
		System.out.println("Stage1");
		p.Stage1();
		p.displayMatrix();
		
		
		/*p.Stage1();
		p.Stage2();
		p.Stage3();*/
		//without stage 1,2,3 --> p.displayMatrix() --> initial Input (test ops on this)
		
		//+ p.stage1() --> expected resut (Stage1 testing)
		//------
		
	}
	
	
	@Test
	public void testStage1_1PANDA() {
		
		
		//Define a few Person
		Person A = new Person("A","1","M","YYY");
		Person B = new Person("B","2","M","YYY");
		Person C = new Person("C","3","M","YYY");
		Person D = new Person("D","4","M","YYY");
		Person E = new Person("E","5","M","YYY");
		Person F = new Person("F","1","M","YYY");
		
		
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(D), new CellPreference(F), new CellPreference(A), new CellPreference(E), new CellPreference(B) },
				  { new CellSubject(D), new CellPreference(A), new CellPreference(C), new CellPreference(E), new CellPreference(B), new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(F), new CellPreference(A), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		};
		
		//Declare the 3 additional states required -- Remains unchanged
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		//you will make this matrix once you see the output from p.displayMatrix() <-- actual output (cheating) [de-comment p.displayMatrix()]
		//Don't make the matrix yet. Look at the actual output!
		/*
		 * Interpreting the actual output that's displayed on the console
		 * 
		 * 1) (N) --> CStateAvailable (No changes required)
		 * 2) (A) --> CStateAccepted  (I have done constructor overloading [look below], when you make the expected array[the one below] add "accepted" as the second argument)
		 * 3) (P) --> CStateProposalMade (I have done constructor overloading [look below], when you make the expected array[the one below] add "proposalMade" as the second argument)
		 * 4) (R) --> CStateRejected (I have done constructor overloading [look below], when you make the expected array[the one below] add "rejected" as the second argument)
		 *
		 *
		 *accepted, proposalMade and rejected are define above
		 */
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,rejected), new CellPreference(F,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected) },
				  { new CellSubject(C), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected) },
				  { new CellSubject(D), new CellPreference(A,rejected), new CellPreference(C,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(F,accepted) },
				  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,accepted), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(F), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		
				
		};
		System.out.println("======\nThis is PANDA's test [Stage1_1]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		System.out.println("PANDA Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("PANDA Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}

	
	
	

}
