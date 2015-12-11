package TestCases;


import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Stage2IntegrationTesting {

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
	public void test_stage2_PropToFav_FormCyc_RemovSym_FindCell_1()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
		
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
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
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
	public void test_stage2_PropToFav_FormCyc_RemovSym_FindCell_2()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
		
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
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
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
		
		
		n.removeSymmetrically(B, D);
		
		
		Cell actualCell = n.findCell(B, D);
		
		Cell ExpectedCell = new CellPreference(D,new CStateRejected());
		
		
		//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		
	}
	
	
	
	@Test
	public void test_stage2_PropToFav_FormCyc_RemovSym_FindCell_3()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
		
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
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
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
		
		
		n.removeSymmetrically(C, F);
		
		
		Cell actualCell = n.findCell(C, F);
		
		Cell ExpectedCell = new CellPreference(F,new CStateRejected());
		
		
		//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		
	}
	
	
	
	@Test
	public void test_stage2_PropToFav_FormCyc_RemovSym_FindCell_4()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
		
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
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		
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
		
		
		n.removeSymmetrically(D, J);
		
		
		Cell actualCell = n.findCell(D, J);
		
		Cell ExpectedCell = new CellPreference(J,new CStateRejected());
		
		
		//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		
	}
	
	
	
}
