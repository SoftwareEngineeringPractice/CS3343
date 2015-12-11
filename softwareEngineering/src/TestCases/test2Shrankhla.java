package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class test2Shrankhla {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	
	
	@Test
	public void testStage1_2SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1001","M","YYY");
		Person B = new Person("B","2001","M","YYY");
		Person C = new Person("C","3001","M","YYY");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","YYY");
		Person F = new Person("F","6001","M","YYY");
		Person G = new Person("G","7001","M","YYY");
		Person H = new Person("H","8001","M","YYY");
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(C),new CellPreference(G)},
				  { new CellSubject(B), new CellPreference(A), new CellPreference(E), new CellPreference(D), new CellPreference(F), new CellPreference(H),new CellPreference(G),new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(D), new CellPreference(F), new CellPreference(E), new CellPreference(G), new CellPreference(B),new CellPreference(A),new CellPreference(H) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(A), new CellPreference(C), new CellPreference(B), new CellPreference(G),new CellPreference(H),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(G),new CellPreference(C),new CellPreference(H)},
				  { new CellSubject(F), new CellPreference(A), new CellPreference(C), new CellPreference(B), new CellPreference(E), new CellPreference(D),new CellPreference(G),new CellPreference(H) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E),new CellPreference(F)},
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(E),new CellPreference(B),new CellPreference(F)},
		
		
		
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();

		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,proposalMade), new CellPreference(E,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(C,rejected),new CellPreference(G,rejected) },
				  { new CellSubject(B), new CellPreference(A,accepted), new CellPreference(E,proposalMade), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected)},
				  { new CellSubject(C), new CellPreference(D,proposalMade), new CellPreference(F,accepted), new CellPreference(E,rejected), new CellPreference(G,rejected), new CellPreference(B,rejected),new CellPreference(A,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(G,rejected),new CellPreference(H,proposalMade),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B,accepted), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(F), new CellPreference(A,rejected), new CellPreference(C,proposalMade), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,accepted), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected)},
				  
		
		
		
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}

	
	@Test
	public void testStage2_2SHRANKHLA() {
		
		
		//Define a few Person
		Person A = new Person("A","1001","M","YYY");
		Person B = new Person("B","2001","M","YYY");
		Person C = new Person("C","3001","M","YYY");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","YYY");
		Person F = new Person("F","6001","M","YYY");
		Person G = new Person("G","7001","M","YYY");
		Person H = new Person("H","8001","M","YYY");
		
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(C),new CellPreference(G)},
				  { new CellSubject(B), new CellPreference(A), new CellPreference(E), new CellPreference(D), new CellPreference(F), new CellPreference(H),new CellPreference(G),new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(D), new CellPreference(F), new CellPreference(E), new CellPreference(G), new CellPreference(B),new CellPreference(A),new CellPreference(H) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(A), new CellPreference(C), new CellPreference(B), new CellPreference(G),new CellPreference(H),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(G),new CellPreference(C),new CellPreference(H)},
				  { new CellSubject(F), new CellPreference(A), new CellPreference(C), new CellPreference(B), new CellPreference(E), new CellPreference(D),new CellPreference(G),new CellPreference(H) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E),new CellPreference(F)},
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(E),new CellPreference(B),new CellPreference(F)},
		
		
		
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,proposalMade), new CellPreference(E,accepted), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(C,rejected),new CellPreference(G,rejected) },
				  { new CellSubject(B), new CellPreference(A,accepted), new CellPreference(E,rejected), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected)},
				  { new CellSubject(C), new CellPreference(D,proposalMade), new CellPreference(F,accepted), new CellPreference(E,rejected), new CellPreference(G,rejected), new CellPreference(B,rejected),new CellPreference(A,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(F), new CellPreference(A,rejected), new CellPreference(C,proposalMade), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected)},
				  
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}

	
	
	@Test
	public void testStage3_2SHRANKHLA() {
		
		Person A = new Person("A","1001","M","YYY");
		Person B = new Person("B","2001","M","YYY");
		Person C = new Person("C","3001","M","YYY");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","YYY");
		Person F = new Person("F","6001","M","YYY");
		Person G = new Person("G","7001","M","YYY");
		Person H = new Person("H","8001","M","YYY");
		
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(C),new CellPreference(G)},
				  { new CellSubject(B), new CellPreference(A), new CellPreference(E), new CellPreference(D), new CellPreference(F), new CellPreference(H),new CellPreference(G),new CellPreference(C) },
				  { new CellSubject(C), new CellPreference(D), new CellPreference(F), new CellPreference(E), new CellPreference(G), new CellPreference(B),new CellPreference(A),new CellPreference(H) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(A), new CellPreference(C), new CellPreference(B), new CellPreference(G),new CellPreference(H),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(D), new CellPreference(F), new CellPreference(G),new CellPreference(C),new CellPreference(H)},
				  { new CellSubject(F), new CellPreference(A), new CellPreference(C), new CellPreference(B), new CellPreference(E), new CellPreference(D),new CellPreference(G),new CellPreference(H) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E),new CellPreference(F)},
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(E),new CellPreference(B),new CellPreference(F)},
		
		
		
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,proposalMade), new CellPreference(E,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected), new CellPreference(H,rejected),new CellPreference(C,rejected),new CellPreference(G,rejected) },
				  { new CellSubject(B), new CellPreference(A,accepted), new CellPreference(E,rejected), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(H,rejected),new CellPreference(G,rejected),new CellPreference(C,rejected)},
				  { new CellSubject(C), new CellPreference(D,proposalMade), new CellPreference(F,rejected), new CellPreference(E,rejected), new CellPreference(G,rejected), new CellPreference(B,rejected),new CellPreference(A,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(D), new CellPreference(E,rejected), new CellPreference(A,rejected), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(G,rejected),new CellPreference(H,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(A,rejected), new CellPreference(B,rejected), new CellPreference(D,rejected), new CellPreference(F,rejected), new CellPreference(G,rejected),new CellPreference(C,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(F), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(E,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected),new CellPreference(H,rejected)},
				  { new CellSubject(G), new CellPreference(H,accepted), new CellPreference(D,rejected), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(H), new CellPreference(G,proposalMade), new CellPreference(D,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(E,rejected),new CellPreference(B,rejected),new CellPreference(F,rejected)},
				  
		
		
		
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();

		assertArrayEquals(p.getMatrix(),expected);
		
	}

	


	
	
}