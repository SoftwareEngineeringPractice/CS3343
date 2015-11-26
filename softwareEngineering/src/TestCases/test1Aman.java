package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;


public class test1Aman {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	
	
	
	
	@Test
	public void getresultAman(){
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/1am.txt");
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		
		//check - works properly?
		
		//---------------
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
		/*studentOfficeInstance.makePreferences(office.getEligibleMaleList());
		p = new PreferenceMatrix(office.getEligibleMaleList());
		System.out.println("Input ");
		p.displayMatrix();
		
		System.out.println("Stage1");
		p.Stage1();
		p.displayMatrix();
		
		System.out.println("Stage2");
		p.Stage1();
		p.Stage2();
		p.displayMatrix();
		
		System.out.println("Stage3");
		p.Stage1();
		p.Stage2();
		p.Stage3();
		p.displayMatrix();*/
		
		
		
		/*p.Stage1();
		p.Stage2();
		p.Stage3();*/
		//without stage 1,2,3 --> p.displayMatrix() --> initial Input (test ops on this)
		
		//+ p.stage1() --> expected resut (Stage1 testing)
		//------
		
	}
	
	
	@Test
	public void testStage1_1Aman() {
		
		
		//Define a few Person
		Person A = new Person("A","1038","M","NNY");
		Person B = new Person("B","1039","M","YNN");
		Person C = new Person("C","1040","M","YNY");
		Person D = new Person("D","1041","M","NYN");
		Person E = new Person("E","1042","M","NYN");
		Person F = new Person("F","1043","M","YYN");
		Person G = new Person("G","1044","M","YNY");
		Person H = new Person("H","1045","M","NNY");
		Person I = new Person("I","1046","M","YYY");
		Person J = new Person("J","1047","M","YNY");
		Person K = new Person("K","1048","M","NYN");
		Person L = new Person("L","1049","M","NYY");
		
		
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//initial array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J), new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) , new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(C), new CellPreference(J), new CellPreference(F), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) , new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) , new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(B), new CellPreference(F), new CellPreference(A), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I) , new CellPreference(K),new CellPreference(L)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(B), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G), new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F), new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F), new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B), new CellPreference(E), new CellPreference(G), new CellPreference(C),new CellPreference(A),new CellPreference(J),new CellPreference(H),new CellPreference(D) , new CellPreference(K),new CellPreference(L)},
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F), new CellPreference(D), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A), new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(K), new CellPreference(E), new CellPreference(F), new CellPreference(A), new CellPreference(C), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(D), new CellPreference(K),new CellPreference(L) },
				  { new CellSubject(L), new CellPreference(C), new CellPreference(G), new CellPreference(D), new CellPreference(A), new CellPreference(I),new CellPreference(F),new CellPreference(H),new CellPreference(B),new CellPreference(E), new CellPreference(K),new CellPreference(L) },
				  
	
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
		 *accepted, proposalMade and rejected are define above*/
		 
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,proposalMade), new CellPreference(E,rejected), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,proposalMade),new CellPreference(G,accepted),new CellPreference(J,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected) },
				  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(A,accepted), new CellPreference(F,rejected), new CellPreference(D,proposalMade), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected) },
				  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,accepted), new CellPreference(D,rejected), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) ,new CellPreference(K,rejected),new CellPreference(L,rejected)},
				  { new CellSubject(D), new CellPreference(E,proposalMade), new CellPreference(B,accepted), new CellPreference(G,proposalMade), new CellPreference(J,rejected), new CellPreference(C,rejected),new CellPreference(A,rejected),new CellPreference(H, rejected),new CellPreference(F,rejected),new CellPreference(I,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected) },
				  { new CellSubject(E), new CellPreference(D,accepted), new CellPreference(B,rejected), new CellPreference(F,rejected), new CellPreference(A,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected)},
				  { new CellSubject(F), new CellPreference(E,rejected), new CellPreference(C,proposalMade), new CellPreference(A,accepted), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) ,new CellPreference(K,rejected),new CellPreference(L,rejected)},
				  { new CellSubject(G), new CellPreference(H,proposalMade), new CellPreference(D,accepted), new CellPreference(A,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected) },
				  { new CellSubject(H), new CellPreference(G,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(G,rejected), new CellPreference(C,rejected),new CellPreference(A,accepted),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected),new CellPreference(K,rejected),new CellPreference(L,rejected) },
				  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected),new CellPreference(K,proposalMade),new CellPreference(L,proposalMade) },
				  { new CellSubject(K), new CellPreference(E,rejected), new CellPreference(F,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(D,rejected) ,new CellPreference(K,rejected),new CellPreference(L,rejected)},
				  { new CellSubject(L), new CellPreference(C,rejected), new CellPreference(G,rejected), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(I,rejected),new CellPreference(F,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected) ,new CellPreference(K,rejected),new CellPreference(L,accepted)},
		
		
		
		};
		System.out.println("======\nThis is Aman's test [Stage1_1]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		System.out.println("Aman Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("Aman Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}

	
	//@Test
	public void testStage2_1Aman() {
		
		
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
		
		//you will make this matrix once you see the output from p.displayMatrix() <-- actual output (cheating) [de-comment p.displayMatrix()]
		//Don't make the matrix yet. Look at the actual output!
		
		 /** Interpreting the actual output that's displayed on the console
		 * 
		 * 1) (N) --> CStateAvailable (No changes required)
		 * 2) (A) --> CStateAccepted  (I have done constructor overloading [look below], when you make the expected array[the one below] add "accepted" as the second argument)
		 * 3) (P) --> CStateProposalMade (I have done constructor overloading [look below], when you make the expected array[the one below] add "proposalMade" as the second argument)
		 * 4) (R) --> CStateRejected (I have done constructor overloading [look below], when you make the expected array[the one below] add "rejected" as the second argument)
		 *
		 *
		 *accepted, proposalMade and rejected are define above*/
		 
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
		System.out.println("======\nThis is Aman's test [Stage2_1]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
		System.out.println("Aman Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("Aman Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	
	
	//@Test
	public void testStage3_1Aman() {
		
		
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
		System.out.println("======\nThis is Aman's test [Stage3_1]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		System.out.println("Aman Actual result state check");
		p.displayMatrix();//[1]
		System.out.println("Aman Expected result state check:");
		
		//Once you have the made the expected out put you could de-comment the below 2 lines to check that the expected output is exactlyy the same
		
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]
		System.out.println("They have to be the same\n========");
		assertArrayEquals(p.getMatrix(),expected);
		
	}



	
	
}