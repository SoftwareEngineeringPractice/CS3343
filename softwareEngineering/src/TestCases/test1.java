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
	
	
	
	@Test
	public void getresult(){
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
	
	
	//@Test
	public void testStage1_1() {
		
		
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
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(B), new CellPreference(A), new CellPreference(A), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(F), new CellPreference(F), new CellPreference(A), new CellPreference(E), new CellPreference(B) },
				  { new CellSubject(D), new CellPreference(C), new CellPreference(A), new CellPreference(B), new CellPreference(C), new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(B), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(F), new CellPreference(B), new CellPreference(C), new CellPreference(A), new CellPreference(E), new CellPreference(D) },
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
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected), new CellPreference(E,rejected) },
				  { new CellSubject(B), new CellPreference(D,rejected), new CellPreference(E,proposalMade), new CellPreference(F,rejected), new CellPreference(A,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(C), new CellPreference(D,proposalMade), new CellPreference(E,accepted), new CellPreference(F,rejected), new CellPreference(A,accepted), new CellPreference(B,rejected) },
				  { new CellSubject(D), new CellPreference(F,rejected), new CellPreference(C,accepted), new CellPreference(A,accepted), new CellPreference(E,rejected), new CellPreference(B,rejected) },
				  { new CellSubject(E), new CellPreference(F,rejected), new CellPreference(C,proposalMade), new CellPreference(D,rejected), new CellPreference(B,accepted), new CellPreference(A,proposalMade) },
				  { new CellSubject(F), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(D), new CellPreference(C), new CellPreference(E) },
		  
				
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		//p.Stage1();
		p.displayMatrix();
		System.out.println("----");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		//PreferenceMatrix e = new PreferenceMatrix(expected);
		//e.displayMatrix();
		
		//assertArrayEquals(p.getMatrix(),expected);
		
	}

	
	
	

}
