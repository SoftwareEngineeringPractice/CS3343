package TestCases;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StageTesting {
	
	

	SRO sro;
	StudentOffice officeInstance;
	Office office;
	

	@Before
	public void setup(){
		sro = SRO.getInstance();
		officeInstance = StudentOffice.getOffice();
		office = Office.getOffice();
		
	}
	
	@Test
	public void test_stage1_stage2_stage3_1()


	{
		//Define a few Person
				Person A = new Person("A","1001","M","YYY");
				Person B = new Person("B","2001","M","YYY");
				Person C = new Person("C","3001","M","YYY");
				Person D = new Person("D","4001","M","YYY");
				Person E = new Person("E","5001","M","YYY");
				Person F = new Person("F","6001","M","YYY");
				Person G = new Person("G","7001","M","YYY");
				Person H = new Person("H","8001","M","YYY");
				Person I = new Person("I","1008","M","YYY");
				Person J = new Person("J","1009","M","YYY");
				Person K = new Person("K","1010","M","YYY");
				Person L = new Person("L","1011","M","YYY");
				Person M = new Person("M","1011","M","YYY");
				
				
				
				
				
				//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
				
				//imital array
				Cell[][] preferenceList = new Cell[][]{
						  { new CellSubject(A), new CellPreference(J), new CellPreference(D), new CellPreference(F), new CellPreference(B), new CellPreference(H),new CellPreference(E),new CellPreference(M),new CellPreference(K),new CellPreference(G),new CellPreference(C),new CellPreference(I),new CellPreference(L) },
						  { new CellSubject(B), new CellPreference(F), new CellPreference(K), new CellPreference(A), new CellPreference(C), new CellPreference(E),new CellPreference(M),new CellPreference(H),new CellPreference(L),new CellPreference(D),new CellPreference(I),new CellPreference(J),new CellPreference(G) },
						  { new CellSubject(C), new CellPreference(H), new CellPreference(M), new CellPreference(K), new CellPreference(F), new CellPreference(J),new CellPreference(I),new CellPreference(B),new CellPreference(L),new CellPreference(E),new CellPreference(G),new CellPreference(A),new CellPreference(D) },
						  { new CellSubject(D), new CellPreference(A), new CellPreference(E), new CellPreference(G), new CellPreference(L), new CellPreference(J),new CellPreference(B),new CellPreference(F),new CellPreference(I),new CellPreference(M),new CellPreference(K),new CellPreference(H),new CellPreference(C) },
						  { new CellSubject(E), new CellPreference(I), new CellPreference(B), new CellPreference(L), new CellPreference(F), new CellPreference(D),new CellPreference(K),new CellPreference(A),new CellPreference(C),new CellPreference(H),new CellPreference(M),new CellPreference(G),new CellPreference(J) },
						  { new CellSubject(F), new CellPreference(B), new CellPreference(K), new CellPreference(C), new CellPreference(M), new CellPreference(A),new CellPreference(E),new CellPreference(H),new CellPreference(D),new CellPreference(L),new CellPreference(J),new CellPreference(I),new CellPreference(G) },
						  { new CellSubject(G), new CellPreference(L), new CellPreference(I), new CellPreference(D), new CellPreference(J), new CellPreference(E),new CellPreference(H),new CellPreference(C),new CellPreference(A),new CellPreference(K),new CellPreference(M),new CellPreference(B),new CellPreference(F) },
						  { new CellSubject(H), new CellPreference(M), new CellPreference(K), new CellPreference(C), new CellPreference(F), new CellPreference(I),new CellPreference(B),new CellPreference(J),new CellPreference(L),new CellPreference(E),new CellPreference(G),new CellPreference(A),new CellPreference(D) },
						  { new CellSubject(I), new CellPreference(L), new CellPreference(H), new CellPreference(E), new CellPreference(C), new CellPreference(G),new CellPreference(K),new CellPreference(M),new CellPreference(B),new CellPreference(F),new CellPreference(J),new CellPreference(D),new CellPreference(A) },
						  { new CellSubject(J), new CellPreference(M), new CellPreference(C), new CellPreference(A), new CellPreference(H), new CellPreference(K),new CellPreference(G),new CellPreference(I),new CellPreference(B),new CellPreference(D),new CellPreference(F),new CellPreference(L),new CellPreference(E) },
						  { new CellSubject(K), new CellPreference(H), new CellPreference(M), new CellPreference(C), new CellPreference(F), new CellPreference(J),new CellPreference(L),new CellPreference(B),new CellPreference(I),new CellPreference(E),new CellPreference(A),new CellPreference(G),new CellPreference(D) },
						  { new CellSubject(L), new CellPreference(I), new CellPreference(C), new CellPreference(E), new CellPreference(M), new CellPreference(K),new CellPreference(G),new CellPreference(H),new CellPreference(J),new CellPreference(B),new CellPreference(F),new CellPreference(D),new CellPreference(A) },
						  { new CellSubject(M), new CellPreference(C), new CellPreference(H), new CellPreference(K), new CellPreference(B), new CellPreference(F),new CellPreference(I),new CellPreference(J),new CellPreference(L),new CellPreference(G),new CellPreference(A),new CellPreference(E),new CellPreference(D) },
						    
				
				
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
						  { new CellSubject(A), new CellPreference(J,proposalMade), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(H,rejected),new CellPreference(E,rejected),new CellPreference(M,rejected),new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected),new CellPreference(L,proposalMade) },
						  { new CellSubject(B), new CellPreference(F,proposalMade), new CellPreference(K,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(E,accepted),new CellPreference(M,rejected),new CellPreference(H,rejected),new CellPreference(L,proposalMade),new CellPreference(D,rejected),new CellPreference(I,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(C), new CellPreference(H,proposalMade), new CellPreference(M,rejected), new CellPreference(K,rejected), new CellPreference(F,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(L,accepted),new CellPreference(E,rejected),new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(D), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(G,accepted), new CellPreference(L,rejected), new CellPreference(J,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(I,rejected),new CellPreference(M,proposalMade),new CellPreference(K,rejected),new CellPreference(H,rejected),new CellPreference(C,rejected) },
						  { new CellSubject(E), new CellPreference(I,rejected), new CellPreference(B,proposalMade), new CellPreference(L,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(K,rejected),new CellPreference(A,rejected),new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(M,accepted),new CellPreference(G,rejected),new CellPreference(J,rejected) },
						  { new CellSubject(F), new CellPreference(B,accepted), new CellPreference(K,rejected), new CellPreference(C,rejected), new CellPreference(M,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected),new CellPreference(L,proposalMade),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(G), new CellPreference(L,rejected), new CellPreference(I,rejected), new CellPreference(D,proposalMade), new CellPreference(J,rejected), new CellPreference(E,rejected),new CellPreference(H,rejected),new CellPreference(C,rejected),new CellPreference(A,rejected),new CellPreference(K,rejected),new CellPreference(M,proposalMade),new CellPreference(B,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(H), new CellPreference(M,rejected), new CellPreference(K,proposalMade), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(L,proposalMade),new CellPreference(E,rejected),new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(I), new CellPreference(L,rejected), new CellPreference(H,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(G,rejected),new CellPreference(K,rejected),new CellPreference(M,accepted),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(J,rejected),new CellPreference(D,rejected),new CellPreference(A,rejected) },
						  { new CellSubject(J), new CellPreference(M,rejected), new CellPreference(C,rejected), new CellPreference(A,accepted), new CellPreference(H,rejected), new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(D,rejected),new CellPreference(F,rejected),new CellPreference(L,proposalMade),new CellPreference(E,rejected) },
						  { new CellSubject(K), new CellPreference(H,accepted), new CellPreference(M,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected), new CellPreference(J,rejected),new CellPreference(L,proposalMade),new CellPreference(B,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(A,rejected),new CellPreference(G,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(L), new CellPreference(I,rejected), new CellPreference(C,rejected), new CellPreference(E,rejected), new CellPreference(M,rejected), new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(D,rejected),new CellPreference(A,rejected) },
						  { new CellSubject(M), new CellPreference(C,proposalMade), new CellPreference(H), new CellPreference(K), new CellPreference(B), new CellPreference(F),new CellPreference(I),new CellPreference(J),new CellPreference(L),new CellPreference(G),new CellPreference(A),new CellPreference(E),new CellPreference(D) },
						    
				
				
				};
				//System.out.println("======\nThis is SHRANKHLA's test [Stage3_4]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
				PreferenceMatrix p = new PreferenceMatrix(preferenceList);
				
				p.Stage1();
				p.Stage2();
				p.Stage3();
				
				PreferenceMatrix e = new PreferenceMatrix(p.getMatrix());
				
				e.proposeToFav(1);
				
				//e.displayMatrix();
				
				Cell[][] expected1 = new Cell[][]{
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
				
				
				PreferenceMatrix m = new PreferenceMatrix(expected1);
				
				m.formCycle(1);
				
				//m.displayMatrix();
				
				Cell[][] expected2 = new Cell[][]{
						  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected) },
						  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,rejected), new CellPreference(D,accepted), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(J,rejected), new CellPreference(C,proposalMade),new CellPreference(A,rejected),new CellPreference(H,proposalMade),new CellPreference(F,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected)},
						  { new CellSubject(F), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,accepted), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected) },
				
				
				
				};
				
				PreferenceMatrix n = new PreferenceMatrix(expected2);
				
				
				n.removeSymmetrically(A, J);
				
				
				Cell actualCell = n.findCell(A, J);
				
				Cell ExpectedCell = new CellPreference(J,new CStateRejected());
				
				
				//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
				
				assertEquals(actualCell,ExpectedCell);
			
				
		
	}
	
	
	
	@Test
	public void test_stage1_stage2_stage3_3()


	{
		//Define a few Person
				Person A = new Person("A","1001","M","YYY");
				Person B = new Person("B","2001","M","YYY");
				Person C = new Person("C","3001","M","YYY");
				Person D = new Person("D","4001","M","YYY");
				Person E = new Person("E","5001","M","YYY");
				Person F = new Person("F","6001","M","YYY");
				Person G = new Person("G","7001","M","YYY");
				Person H = new Person("H","8001","M","YYY");
				Person I = new Person("I","1008","M","YYY");
				Person J = new Person("J","1009","M","YYY");
				Person K = new Person("K","1010","M","YYY");
				Person L = new Person("L","1011","M","YYY");
				Person M = new Person("M","1011","M","YYY");
				
				
				
				
				
				//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
				
				//imital array
				Cell[][] preferenceList = new Cell[][]{
						  { new CellSubject(A), new CellPreference(J), new CellPreference(D), new CellPreference(F), new CellPreference(B), new CellPreference(H),new CellPreference(E),new CellPreference(M),new CellPreference(K),new CellPreference(G),new CellPreference(C),new CellPreference(I),new CellPreference(L) },
						  { new CellSubject(B), new CellPreference(F), new CellPreference(K), new CellPreference(A), new CellPreference(C), new CellPreference(E),new CellPreference(M),new CellPreference(H),new CellPreference(L),new CellPreference(D),new CellPreference(I),new CellPreference(J),new CellPreference(G) },
						  { new CellSubject(C), new CellPreference(H), new CellPreference(M), new CellPreference(K), new CellPreference(F), new CellPreference(J),new CellPreference(I),new CellPreference(B),new CellPreference(L),new CellPreference(E),new CellPreference(G),new CellPreference(A),new CellPreference(D) },
						  { new CellSubject(D), new CellPreference(A), new CellPreference(E), new CellPreference(G), new CellPreference(L), new CellPreference(J),new CellPreference(B),new CellPreference(F),new CellPreference(I),new CellPreference(M),new CellPreference(K),new CellPreference(H),new CellPreference(C) },
						  { new CellSubject(E), new CellPreference(I), new CellPreference(B), new CellPreference(L), new CellPreference(F), new CellPreference(D),new CellPreference(K),new CellPreference(A),new CellPreference(C),new CellPreference(H),new CellPreference(M),new CellPreference(G),new CellPreference(J) },
						  { new CellSubject(F), new CellPreference(B), new CellPreference(K), new CellPreference(C), new CellPreference(M), new CellPreference(A),new CellPreference(E),new CellPreference(H),new CellPreference(D),new CellPreference(L),new CellPreference(J),new CellPreference(I),new CellPreference(G) },
						  { new CellSubject(G), new CellPreference(L), new CellPreference(I), new CellPreference(D), new CellPreference(J), new CellPreference(E),new CellPreference(H),new CellPreference(C),new CellPreference(A),new CellPreference(K),new CellPreference(M),new CellPreference(B),new CellPreference(F) },
						  { new CellSubject(H), new CellPreference(M), new CellPreference(K), new CellPreference(C), new CellPreference(F), new CellPreference(I),new CellPreference(B),new CellPreference(J),new CellPreference(L),new CellPreference(E),new CellPreference(G),new CellPreference(A),new CellPreference(D) },
						  { new CellSubject(I), new CellPreference(L), new CellPreference(H), new CellPreference(E), new CellPreference(C), new CellPreference(G),new CellPreference(K),new CellPreference(M),new CellPreference(B),new CellPreference(F),new CellPreference(J),new CellPreference(D),new CellPreference(A) },
						  { new CellSubject(J), new CellPreference(M), new CellPreference(C), new CellPreference(A), new CellPreference(H), new CellPreference(K),new CellPreference(G),new CellPreference(I),new CellPreference(B),new CellPreference(D),new CellPreference(F),new CellPreference(L),new CellPreference(E) },
						  { new CellSubject(K), new CellPreference(H), new CellPreference(M), new CellPreference(C), new CellPreference(F), new CellPreference(J),new CellPreference(L),new CellPreference(B),new CellPreference(I),new CellPreference(E),new CellPreference(A),new CellPreference(G),new CellPreference(D) },
						  { new CellSubject(L), new CellPreference(I), new CellPreference(C), new CellPreference(E), new CellPreference(M), new CellPreference(K),new CellPreference(G),new CellPreference(H),new CellPreference(J),new CellPreference(B),new CellPreference(F),new CellPreference(D),new CellPreference(A) },
						  { new CellSubject(M), new CellPreference(C), new CellPreference(H), new CellPreference(K), new CellPreference(B), new CellPreference(F),new CellPreference(I),new CellPreference(J),new CellPreference(L),new CellPreference(G),new CellPreference(A),new CellPreference(E),new CellPreference(D) },
						    
				
				
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
						  { new CellSubject(A), new CellPreference(J,proposalMade), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(H,rejected),new CellPreference(E,rejected),new CellPreference(M,rejected),new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected),new CellPreference(L,proposalMade) },
						  { new CellSubject(B), new CellPreference(F,proposalMade), new CellPreference(K,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(E,accepted),new CellPreference(M,rejected),new CellPreference(H,rejected),new CellPreference(L,proposalMade),new CellPreference(D,rejected),new CellPreference(I,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(C), new CellPreference(H,proposalMade), new CellPreference(M,rejected), new CellPreference(K,rejected), new CellPreference(F,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(L,accepted),new CellPreference(E,rejected),new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(D), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(G,accepted), new CellPreference(L,rejected), new CellPreference(J,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(I,rejected),new CellPreference(M,proposalMade),new CellPreference(K,rejected),new CellPreference(H,rejected),new CellPreference(C,rejected) },
						  { new CellSubject(E), new CellPreference(I,rejected), new CellPreference(B,proposalMade), new CellPreference(L,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(K,rejected),new CellPreference(A,rejected),new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(M,accepted),new CellPreference(G,rejected),new CellPreference(J,rejected) },
						  { new CellSubject(F), new CellPreference(B,accepted), new CellPreference(K,rejected), new CellPreference(C,rejected), new CellPreference(M,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected),new CellPreference(L,proposalMade),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(G), new CellPreference(L,rejected), new CellPreference(I,rejected), new CellPreference(D,proposalMade), new CellPreference(J,rejected), new CellPreference(E,rejected),new CellPreference(H,rejected),new CellPreference(C,rejected),new CellPreference(A,rejected),new CellPreference(K,rejected),new CellPreference(M,proposalMade),new CellPreference(B,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(H), new CellPreference(M,rejected), new CellPreference(K,proposalMade), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(L,proposalMade),new CellPreference(E,rejected),new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(I), new CellPreference(L,rejected), new CellPreference(H,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(G,rejected),new CellPreference(K,rejected),new CellPreference(M,accepted),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(J,rejected),new CellPreference(D,rejected),new CellPreference(A,rejected) },
						  { new CellSubject(J), new CellPreference(M,rejected), new CellPreference(C,rejected), new CellPreference(A,accepted), new CellPreference(H,rejected), new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(D,rejected),new CellPreference(F,rejected),new CellPreference(L,proposalMade),new CellPreference(E,rejected) },
						  { new CellSubject(K), new CellPreference(H,accepted), new CellPreference(M,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected), new CellPreference(J,rejected),new CellPreference(L,proposalMade),new CellPreference(B,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(A,rejected),new CellPreference(G,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(L), new CellPreference(I,rejected), new CellPreference(C,rejected), new CellPreference(E,rejected), new CellPreference(M,rejected), new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(D,rejected),new CellPreference(A,rejected) },
						  { new CellSubject(M), new CellPreference(C,proposalMade), new CellPreference(H), new CellPreference(K), new CellPreference(B), new CellPreference(F),new CellPreference(I),new CellPreference(J),new CellPreference(L),new CellPreference(G),new CellPreference(A),new CellPreference(E),new CellPreference(D) },
						    
				
				
				};
				//System.out.println("======\nThis is SHRANKHLA's test [Stage3_4]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
				PreferenceMatrix p = new PreferenceMatrix(preferenceList);
				
				p.Stage1();
				p.Stage2();
				p.Stage3();
				
				PreferenceMatrix e = new PreferenceMatrix(p.getMatrix());
				
				e.proposeToFav(1);
				
				//e.displayMatrix();
				
				Cell[][] expected1 = new Cell[][]{
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
				
				
				PreferenceMatrix m = new PreferenceMatrix(expected1);
				
				m.formCycle(1);
				
				//m.displayMatrix();
				
				Cell[][] expected2 = new Cell[][]{
						  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected) },
						  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,rejected), new CellPreference(D,accepted), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(J,rejected), new CellPreference(C,proposalMade),new CellPreference(A,rejected),new CellPreference(H,proposalMade),new CellPreference(F,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected)},
						  { new CellSubject(F), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,accepted), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected) },
				
				
				
				};
				
				PreferenceMatrix n = new PreferenceMatrix(expected2);
				
				
				n.removeSymmetrically(C, E);
				
				
				Cell actualCell = n.findCell(C, E);
				
				Cell ExpectedCell = new CellPreference(E,new CStateRejected());
				
				
				//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
				
				assertEquals(actualCell,ExpectedCell);
			
				
		
	}
	

	@Test
	public void test_stage1_stage2_stage3_2()


	{
		//Define a few Person
				Person A = new Person("A","1001","M","YYY");
				Person B = new Person("B","2001","M","YYY");
				Person C = new Person("C","3001","M","YYY");
				Person D = new Person("D","4001","M","YYY");
				Person E = new Person("E","5001","M","YYY");
				Person F = new Person("F","6001","M","YYY");
				Person G = new Person("G","7001","M","YYY");
				Person H = new Person("H","8001","M","YYY");
				Person I = new Person("I","1008","M","YYY");
				Person J = new Person("J","1009","M","YYY");
				Person K = new Person("K","1010","M","YYY");
				Person L = new Person("L","1011","M","YYY");
				Person M = new Person("M","1011","M","YYY");
				
				
				
				
				
				//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
				
				//imital array
				Cell[][] preferenceList = new Cell[][]{
						  { new CellSubject(A), new CellPreference(J), new CellPreference(D), new CellPreference(F), new CellPreference(B), new CellPreference(H),new CellPreference(E),new CellPreference(M),new CellPreference(K),new CellPreference(G),new CellPreference(C),new CellPreference(I),new CellPreference(L) },
						  { new CellSubject(B), new CellPreference(F), new CellPreference(K), new CellPreference(A), new CellPreference(C), new CellPreference(E),new CellPreference(M),new CellPreference(H),new CellPreference(L),new CellPreference(D),new CellPreference(I),new CellPreference(J),new CellPreference(G) },
						  { new CellSubject(C), new CellPreference(H), new CellPreference(M), new CellPreference(K), new CellPreference(F), new CellPreference(J),new CellPreference(I),new CellPreference(B),new CellPreference(L),new CellPreference(E),new CellPreference(G),new CellPreference(A),new CellPreference(D) },
						  { new CellSubject(D), new CellPreference(A), new CellPreference(E), new CellPreference(G), new CellPreference(L), new CellPreference(J),new CellPreference(B),new CellPreference(F),new CellPreference(I),new CellPreference(M),new CellPreference(K),new CellPreference(H),new CellPreference(C) },
						  { new CellSubject(E), new CellPreference(I), new CellPreference(B), new CellPreference(L), new CellPreference(F), new CellPreference(D),new CellPreference(K),new CellPreference(A),new CellPreference(C),new CellPreference(H),new CellPreference(M),new CellPreference(G),new CellPreference(J) },
						  { new CellSubject(F), new CellPreference(B), new CellPreference(K), new CellPreference(C), new CellPreference(M), new CellPreference(A),new CellPreference(E),new CellPreference(H),new CellPreference(D),new CellPreference(L),new CellPreference(J),new CellPreference(I),new CellPreference(G) },
						  { new CellSubject(G), new CellPreference(L), new CellPreference(I), new CellPreference(D), new CellPreference(J), new CellPreference(E),new CellPreference(H),new CellPreference(C),new CellPreference(A),new CellPreference(K),new CellPreference(M),new CellPreference(B),new CellPreference(F) },
						  { new CellSubject(H), new CellPreference(M), new CellPreference(K), new CellPreference(C), new CellPreference(F), new CellPreference(I),new CellPreference(B),new CellPreference(J),new CellPreference(L),new CellPreference(E),new CellPreference(G),new CellPreference(A),new CellPreference(D) },
						  { new CellSubject(I), new CellPreference(L), new CellPreference(H), new CellPreference(E), new CellPreference(C), new CellPreference(G),new CellPreference(K),new CellPreference(M),new CellPreference(B),new CellPreference(F),new CellPreference(J),new CellPreference(D),new CellPreference(A) },
						  { new CellSubject(J), new CellPreference(M), new CellPreference(C), new CellPreference(A), new CellPreference(H), new CellPreference(K),new CellPreference(G),new CellPreference(I),new CellPreference(B),new CellPreference(D),new CellPreference(F),new CellPreference(L),new CellPreference(E) },
						  { new CellSubject(K), new CellPreference(H), new CellPreference(M), new CellPreference(C), new CellPreference(F), new CellPreference(J),new CellPreference(L),new CellPreference(B),new CellPreference(I),new CellPreference(E),new CellPreference(A),new CellPreference(G),new CellPreference(D) },
						  { new CellSubject(L), new CellPreference(I), new CellPreference(C), new CellPreference(E), new CellPreference(M), new CellPreference(K),new CellPreference(G),new CellPreference(H),new CellPreference(J),new CellPreference(B),new CellPreference(F),new CellPreference(D),new CellPreference(A) },
						  { new CellSubject(M), new CellPreference(C), new CellPreference(H), new CellPreference(K), new CellPreference(B), new CellPreference(F),new CellPreference(I),new CellPreference(J),new CellPreference(L),new CellPreference(G),new CellPreference(A),new CellPreference(E),new CellPreference(D) },
						    
				
				
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
						  { new CellSubject(A), new CellPreference(J,proposalMade), new CellPreference(D,accepted), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(H,rejected),new CellPreference(E,rejected),new CellPreference(M,rejected),new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected),new CellPreference(L,proposalMade) },
						  { new CellSubject(B), new CellPreference(F,proposalMade), new CellPreference(K,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(E,accepted),new CellPreference(M,rejected),new CellPreference(H,rejected),new CellPreference(L,proposalMade),new CellPreference(D,rejected),new CellPreference(I,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(C), new CellPreference(H,proposalMade), new CellPreference(M,rejected), new CellPreference(K,rejected), new CellPreference(F,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(L,accepted),new CellPreference(E,rejected),new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(D), new CellPreference(A,proposalMade), new CellPreference(E,rejected), new CellPreference(G,accepted), new CellPreference(L,rejected), new CellPreference(J,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(I,rejected),new CellPreference(M,proposalMade),new CellPreference(K,rejected),new CellPreference(H,rejected),new CellPreference(C,rejected) },
						  { new CellSubject(E), new CellPreference(I,rejected), new CellPreference(B,proposalMade), new CellPreference(L,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(K,rejected),new CellPreference(A,rejected),new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(M,accepted),new CellPreference(G,rejected),new CellPreference(J,rejected) },
						  { new CellSubject(F), new CellPreference(B,accepted), new CellPreference(K,rejected), new CellPreference(C,rejected), new CellPreference(M,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected),new CellPreference(L,proposalMade),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(G), new CellPreference(L,rejected), new CellPreference(I,rejected), new CellPreference(D,proposalMade), new CellPreference(J,rejected), new CellPreference(E,rejected),new CellPreference(H,rejected),new CellPreference(C,rejected),new CellPreference(A,rejected),new CellPreference(K,rejected),new CellPreference(M,proposalMade),new CellPreference(B,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(H), new CellPreference(M,rejected), new CellPreference(K,proposalMade), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(L,proposalMade),new CellPreference(E,rejected),new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(I), new CellPreference(L,rejected), new CellPreference(H,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(G,rejected),new CellPreference(K,rejected),new CellPreference(M,accepted),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(J,rejected),new CellPreference(D,rejected),new CellPreference(A,rejected) },
						  { new CellSubject(J), new CellPreference(M,rejected), new CellPreference(C,rejected), new CellPreference(A,accepted), new CellPreference(H,rejected), new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(I,rejected),new CellPreference(B,rejected),new CellPreference(D,rejected),new CellPreference(F,rejected),new CellPreference(L,proposalMade),new CellPreference(E,rejected) },
						  { new CellSubject(K), new CellPreference(H,accepted), new CellPreference(M,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected), new CellPreference(J,rejected),new CellPreference(L,proposalMade),new CellPreference(B,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(A,rejected),new CellPreference(G,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(L), new CellPreference(I,rejected), new CellPreference(C,rejected), new CellPreference(E,rejected), new CellPreference(M,rejected), new CellPreference(K,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected),new CellPreference(D,rejected),new CellPreference(A,rejected) },
						  { new CellSubject(M), new CellPreference(C,proposalMade), new CellPreference(H), new CellPreference(K), new CellPreference(B), new CellPreference(F),new CellPreference(I),new CellPreference(J),new CellPreference(L),new CellPreference(G),new CellPreference(A),new CellPreference(E),new CellPreference(D) },
						    
				
				
				};
				//System.out.println("======\nThis is SHRANKHLA's test [Stage3_4]\nAs said before if there is still an issue matching the states, match the states in [1] and [2] (commented below in code)");
				PreferenceMatrix p = new PreferenceMatrix(preferenceList);
				
				p.Stage1();
				p.Stage2();
				p.Stage3();
				
				PreferenceMatrix e = new PreferenceMatrix(p.getMatrix());
				
				e.proposeToFav(1);
				
				//e.displayMatrix();
				
				Cell[][] expected1 = new Cell[][]{
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
				
				
				PreferenceMatrix m = new PreferenceMatrix(expected1);
				
				m.formCycle(1);
				
				//m.displayMatrix();
				
				Cell[][] expected2 = new Cell[][]{
						  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected) },
						  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(C,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(C), new CellPreference(J,proposalMade), new CellPreference(F,rejected), new CellPreference(D,accepted), new CellPreference(H,rejected), new CellPreference(G,rejected),new CellPreference(A,rejected),new CellPreference(B,rejected),new CellPreference(E,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(J,rejected), new CellPreference(C,proposalMade),new CellPreference(A,rejected),new CellPreference(H,proposalMade),new CellPreference(F,rejected),new CellPreference(I,rejected) },
						  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(J,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(I,rejected)},
						  { new CellSubject(F), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(D,rejected),new CellPreference(H,rejected),new CellPreference(G,rejected) },
						  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,accepted), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(J,rejected),new CellPreference(I,rejected),new CellPreference(F,rejected) },
						  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected),new CellPreference(G,rejected),new CellPreference(J,rejected),new CellPreference(H,rejected),new CellPreference(D,rejected) },
						  { new CellSubject(J), new CellPreference(C,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(E,rejected), new CellPreference(I,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(B,rejected),new CellPreference(A,rejected) },
				
				
				
				};
				
				PreferenceMatrix n = new PreferenceMatrix(expected2);
				
				
				n.removeSymmetrically(B, H);
				
				
				Cell actualCell = n.findCell(B, H);
				
				Cell ExpectedCell = new CellPreference(H,new CStateRejected());
				
				
				//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
				
				assertEquals(actualCell,ExpectedCell);
			
				
		
	}
	

	
}
