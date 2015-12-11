package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class Test_PreferenceMatrix_Stages_3 {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	
	
	
	
	
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
		
			Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D), new CellPreference(B), new CellPreference(G), new CellPreference(E), new CellPreference(C),new CellPreference(F)},
				  { new CellSubject(B), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(F), new CellPreference(D),new CellPreference(G) },
				  { new CellSubject(C), new CellPreference(F), new CellPreference(B), new CellPreference(G), new CellPreference(A), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(D), new CellPreference(A), new CellPreference(G), new CellPreference(E), new CellPreference(B), new CellPreference(C),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(B), new CellPreference(A), new CellPreference(C), new CellPreference(F),new CellPreference(G)},
				  { new CellSubject(F), new CellPreference(C), new CellPreference(B), new CellPreference(A), new CellPreference(E), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(G), new CellPreference(D), new CellPreference(F), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E)},
				 
		
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(C,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F,accepted), new CellPreference(D,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(C), new CellPreference(F,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(D,rejected)},
				  { new CellSubject(D), new CellPreference(A,accepted), new CellPreference(G,proposalMade), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(D,rejected), new CellPreference(B,accepted), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(F), new CellPreference(C,accepted), new CellPreference(B,proposalMade), new CellPreference(A,rejected), new CellPreference(E,rejected), new CellPreference(E,proposalMade),new CellPreference(D,rejected)},
				  { new CellSubject(G), new CellPreference(D,accepted), new CellPreference(F,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected)},
				  
		
		
		
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
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
		
		
			Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D), new CellPreference(B), new CellPreference(G), new CellPreference(E), new CellPreference(C),new CellPreference(F)},
				  { new CellSubject(B), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(F), new CellPreference(D),new CellPreference(G) },
				  { new CellSubject(C), new CellPreference(F), new CellPreference(B), new CellPreference(G), new CellPreference(A), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(D), new CellPreference(A), new CellPreference(G), new CellPreference(E), new CellPreference(B), new CellPreference(C),new CellPreference(F) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(B), new CellPreference(A), new CellPreference(C), new CellPreference(F),new CellPreference(G)},
				  { new CellSubject(F), new CellPreference(C), new CellPreference(B), new CellPreference(A), new CellPreference(E), new CellPreference(E),new CellPreference(D)},
				  { new CellSubject(G), new CellPreference(D), new CellPreference(F), new CellPreference(C), new CellPreference(B), new CellPreference(A),new CellPreference(E)},
				 
		
		
		
		};
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(C,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(C), new CellPreference(F,proposalMade), new CellPreference(B,accepted), new CellPreference(G,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(D,rejected)},
				  { new CellSubject(D), new CellPreference(A,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(D,rejected), new CellPreference(B,accepted), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(F), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected), new CellPreference(E,proposalMade),new CellPreference(D,rejected)},
				  { new CellSubject(G), new CellPreference(D,rejected), new CellPreference(F,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected)},
				  
		
		
		
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
	
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	
	
	@Test
	public void testStage3_3SHRANKHLA() {
		
		Person A = new Person("A","1001","M","YYN");
		Person B = new Person("B","2001","M","NYN");
		Person C = new Person("C","3001","M","NNN");
		Person D = new Person("D","4001","M","YYY");
		Person E = new Person("E","5001","M","NYY");
		Person F = new Person("F","6001","M","NYN");
		Person G = new Person("G","7001","M","YNY");
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
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(D,proposalMade), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected) },
				  { new CellSubject(B), new CellPreference(E,rejected), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(F,rejected), new CellPreference(D,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(C), new CellPreference(F,proposalMade), new CellPreference(B,rejected), new CellPreference(G,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected),new CellPreference(D,rejected)},
				  { new CellSubject(D), new CellPreference(A,accepted), new CellPreference(G,rejected), new CellPreference(E,rejected), new CellPreference(B,rejected), new CellPreference(C,rejected),new CellPreference(F,rejected)},
				  { new CellSubject(E), new CellPreference(D,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected), new CellPreference(C,rejected), new CellPreference(F,rejected),new CellPreference(G,rejected)},
				  { new CellSubject(F), new CellPreference(C,accepted), new CellPreference(B,rejected), new CellPreference(A,rejected), new CellPreference(E,rejected), new CellPreference(E,proposalMade),new CellPreference(D,rejected)},
				  { new CellSubject(G), new CellPreference(D,rejected), new CellPreference(F,proposalMade), new CellPreference(C,rejected), new CellPreference(B,rejected), new CellPreference(A,rejected),new CellPreference(E,rejected)},
				  
		
		
		
		};
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}


	
	
	

	
	
}