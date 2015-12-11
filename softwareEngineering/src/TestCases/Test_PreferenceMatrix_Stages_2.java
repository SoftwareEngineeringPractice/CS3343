package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;


public class Test_PreferenceMatrix_Stages_2 {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	

	
	@Test
	public void testStage1_1SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1000","M","YYY");
		Person B = new Person("B","1001","M","YYY");
		Person C = new Person("C","1002","M","YYY");
		Person D = new Person("D","1003","M","YYY");
		Person E = new Person("E","1004","M","YYY");
		Person F = new Person("F","1005","M","YYY");
		Person G = new Person("G","1006","M","YYY");
		Person H = new Person("H","1007","M","YYY");
		Person I = new Person("I","1008","M","YYY");
		Person J = new Person("J","1009","M","YYY");
		Person K = new Person("K","1010","M","YYY");
		Person L = new Person("L","1011","M","YYY");
		
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J), new CellPreference(F), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(B), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F), new CellPreference(D), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();

		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,proposalMade), new CellPreference(E,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,rejected), new CellPreference(D,accepted), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(J,rejected), new CellPreference(C,proposalMade),new CellPreference(A,rejected),new CellPreference(H,proposalMade),new CellPreference(F,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B,accepted), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected)},
				  { new CellSubject(F), new CellPreference(E,accepted), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) },
				  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,accepted), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected) },
				  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected) },
		
		
		
		};

		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();

		assertArrayEquals(p.getMatrix(),expected);
		
	}

	
	@Test
	public void testStage2_1SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1000","M","YYY");
		Person B = new Person("B","1001","M","YYY");
		Person C = new Person("C","1002","M","YYY");
		Person D = new Person("D","1003","M","YYY");
		Person E = new Person("E","1004","M","YYY");
		Person F = new Person("F","1005","M","YYY");
		Person G = new Person("G","1006","M","YYY");
		Person H = new Person("H","1007","M","YYY");
		Person I = new Person("I","1008","M","YYY");
		Person J = new Person("J","1009","M","YYY");
		Person K = new Person("K","1010","M","YYY");
		Person L = new Person("L","1011","M","YYY");
		
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J), new CellPreference(F), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(B), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F), new CellPreference(D), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		//Declare the 3 additional states required -- Remains unchanged
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,proposalMade), new CellPreference(E,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,rejected), new CellPreference(D,accepted), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(J,rejected), new CellPreference(C,proposalMade),new CellPreference(A,rejected),new CellPreference(H,proposalMade),new CellPreference(F,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected)},
				  { new CellSubject(F), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) },
				  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,accepted), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected) },
				  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected) },
		
		
		
		};

		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	
	
	@Test
	public void testStage3_1SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1000","M","YYY");
		Person B = new Person("B","1001","M","YYY");
		Person C = new Person("C","1002","M","YYY");
		Person D = new Person("D","1003","M","YYY");
		Person E = new Person("E","1004","M","YYY");
		Person F = new Person("F","1005","M","YYY");
		Person G = new Person("G","1006","M","YYY");
		Person H = new Person("H","1007","M","YYY");
		Person I = new Person("I","1008","M","YYY");
		Person J = new Person("J","1009","M","YYY");
		Person K = new Person("K","1010","M","YYY");
		Person L = new Person("L","1011","M","YYY");
		
		
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J), new CellPreference(F), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(B), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F), new CellPreference(D), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		//Declare the 3 additional states required -- Remains unchanged
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected) },
				  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(J,rejected), new CellPreference(C,rejected),new CellPreference(A,rejected),new CellPreference(H,rejected),new CellPreference(F,rejected),new CellPreference(I,rejected) },
				  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected)},
				  { new CellSubject(F), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) },
				  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected) },
				  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected) },
		
		
		
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}



	
	
}