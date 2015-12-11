package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class test1PANDA {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	
	
	
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
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,rejected), new CellPreference(F,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected) },
				  { new CellSubject(C), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected) },
				  { new CellSubject(D), new CellPreference(A,rejected), new CellPreference(C,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(F,accepted) },
				  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,accepted), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(F), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		
				
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}


	@Test
	public void testStage2_1PANDA() {
		
		
		//Define a few Person
		Person A = new Person("A","1","M","YYY");
		Person B = new Person("B","2","M","YYY");
		Person C = new Person("C","3","M","YYY");
		Person D = new Person("D","4","M","YYY");
		Person E = new Person("E","5","M","YYY");
		Person F = new Person("F","1","M","YYY");
		
		
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(D), new CellPreference(F), new CellPreference(A), new CellPreference(E), new CellPreference(B) },
				  { new CellSubject(D), new CellPreference(A), new CellPreference(C), new CellPreference(E), new CellPreference(B), new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(F), new CellPreference(A), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,rejected), new CellPreference(F,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected) },
				  { new CellSubject(C), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected) },
				  { new CellSubject(D), new CellPreference(A,rejected), new CellPreference(C,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(F,accepted) },
				  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,accepted), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(F), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		
				
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}


	@Test
	public void testStage3_1PANDA() {
		
		
		//Define a few Person
		Person A = new Person("A","1","M","YYY");
		Person B = new Person("B","2","M","YYY");
		Person C = new Person("C","3","M","YYY");
		Person D = new Person("D","4","M","YYY");
		Person E = new Person("E","5","M","YYY");
		Person F = new Person("F","1","M","YYY");
		
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(D), new CellPreference(F), new CellPreference(A), new CellPreference(E), new CellPreference(B) },
				  { new CellSubject(D), new CellPreference(A), new CellPreference(C), new CellPreference(E), new CellPreference(B), new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(C) },
				  { new CellSubject(F), new CellPreference(A), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(C,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,rejected), new CellPreference(F,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected) },
				  { new CellSubject(C), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected) },
				  { new CellSubject(D), new CellPreference(A,rejected), new CellPreference(C,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(F,accepted) },
				  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,accepted), new CellPreference(D,rejected), new CellPreference(F,accepted), new CellPreference(C,rejected) },
				  { new CellSubject(F), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(E), new CellPreference(C), new CellPreference(D) },
		
				
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}


	
	

	

}
