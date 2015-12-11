package TestCases;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import roomSync.CState;
import roomSync.CStateAccepted;
import roomSync.CStateProposalMade;
import roomSync.CStateRejected;
import roomSync.Cell;
import roomSync.CellPreference;
import roomSync.CellSubject;
import roomSync.Hall;
import roomSync.Office;
import roomSync.Person;
import roomSync.PreferenceMatrix;
import roomSync.SRO;
import roomSync.StudentOffice;

public class Test_PreferenceMatrix {
	
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
	public void test_getSecAvaiMatrix_1()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J), new CellPreference(F), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C), new CellPreference(A), new CellPreference(B), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H), new CellPreference(D), new CellPreference(A), new CellPreference(C), new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F), new CellPreference(D), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getSecondAvailablePreference(A);
		
		Person expected = new Person("F","1005","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_getSecAvaiMatrix_2()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getSecondAvailablePreference(B);
		
		Person expected = new Person("A","1000","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	@Test
	public void test_getSecAvaiMatrix_3()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getSecondAvailablePreference(D);
		
		Person expected = new Person("B","1001","M","YYY");
		
		assertEquals(result,expected);
	}
	

	
	@Test
	public void test_getSecAvaiMatrix_4()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getSecondAvailablePreference(G);
		
		Person expected = new Person("A","1000","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	
	
	
	@Test
	public void test_getSecAvaiMatrix_5()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getSecondAvailablePreference(G);
		
		Person expected = new Person("A","1000","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	
	
	@Test
	public void test_LastAvai_Pref_1()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getLastAvailablePreference(A);
		
		
		Person expected = new Person("J","1009","M","YYY");
		
		assertEquals(result,expected);
	}
	

	@Test
	public void test_LastAvai_Pref_2()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getLastAvailablePreference(B);
		
		
		Person expected = new Person("I","1008","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_LastAvai_Pref_3()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getLastAvailablePreference(F);
		
		
		Person expected = new Person("G","1006","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_LastAvai_Pref_4()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getLastAvailablePreference(D);
		
		Person expected = new Person("I","1008","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_LastAvai_Pref_5()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getLastAvailablePreference(J);
		
		Person expected = new Person("A","1001","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	@Test
	public void test_First_Non_Rejected_person_1()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getFirstNonRejectedPerson(A);
	
		
		Person expected = new Person("E","1004","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_First_Non_Rejected_person_2()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getFirstNonRejectedPerson(C);
		
		
		Person expected = new Person("D","1003","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_First_Non_Rejected_person_3()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getFirstNonRejectedPerson(F);
		
		
		Person expected = new Person("E","1004","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_First_Non_Rejected_person_4()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getFirstNonRejectedPerson(J);
		
		
		Person expected = new Person("C","1002","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_First_Non_Rejected_person_5()


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
		
		
		CState accepted = new CStateAccepted();
		CState proposalMade = new CStateProposalMade();
		CState rejected = new CStateRejected();
		//Make the 2D array, first column: CellSubject rest: CellPreference, fill in the People according to preference 
		
		//imital array
		Cell[][] preferenceList = new Cell[][]{
				  { new CellSubject(A), new CellPreference(B,rejected), new CellPreference(E), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(I),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(B), new CellPreference(E,proposalMade), new CellPreference(A,proposalMade), new CellPreference(F), new CellPreference(D), new CellPreference(C),new CellPreference(H),new CellPreference(G),new CellPreference(J),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(J,rejected), new CellPreference(F,rejected), new CellPreference(D), new CellPreference(H), new CellPreference(G),new CellPreference(A),new CellPreference(B),new CellPreference(E),new CellPreference(I) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(B,proposalMade), new CellPreference(G), new CellPreference(J), new CellPreference(C),new CellPreference(A),new CellPreference(H),new CellPreference(F),new CellPreference(I) },
				  { new CellSubject(E), new CellPreference(A,proposalMade), new CellPreference(B), new CellPreference(F), new CellPreference(D), new CellPreference(H),new CellPreference(J),new CellPreference(G),new CellPreference(C),new CellPreference(I)},
				  { new CellSubject(F), new CellPreference(E), new CellPreference(C,rejected), new CellPreference(A,rejected), new CellPreference(B,proposalMade), new CellPreference(J),new CellPreference(I),new CellPreference(D),new CellPreference(H),new CellPreference(G) },
				  { new CellSubject(G), new CellPreference(H,rejected), new CellPreference(D,proposalMade), new CellPreference(A), new CellPreference(C), new CellPreference(B,rejected),new CellPreference(J),new CellPreference(I),new CellPreference(E),new CellPreference(F) },
				  { new CellSubject(H), new CellPreference(G), new CellPreference(D,rejected), new CellPreference(C), new CellPreference(A), new CellPreference(E),new CellPreference(B),new CellPreference(J),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(F,rejected), new CellPreference(B,proposalMade), new CellPreference(E), new CellPreference(A), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(H),new CellPreference(D) },
				  { new CellSubject(J), new CellPreference(C,proposalMade), new CellPreference(F,proposalMade), new CellPreference(D,rejected), new CellPreference(E), new CellPreference(I),new CellPreference(G),new CellPreference(H),new CellPreference(B),new CellPreference(A) },
		
		
		
		};
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		Person result =p.getFirstNonRejectedPerson(H);
		
		
		Person expected = new Person("G","1006","M","YYY");
		
		assertEquals(result,expected);
	}
	
	
	
	@Test
	public void test_AvailableChocieinRow_1()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
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
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		
		int actualRes = p.availableChoicesInRow(1);
		
		
		int expectedRes=3;
		assertEquals(actualRes,expectedRes);
		
	}
	
	
	@Test
	public void test_AvailableChocieinRow_2()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
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
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		
		int actualRes = p.availableChoicesInRow(2);
		
		
		int expectedRes=2;
		assertEquals(actualRes,expectedRes);
		
	}
	
	
	@Test
	public void test_AvailableChocieinRow_3()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
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
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		
		int actualRes = p.availableChoicesInRow(3);
		
		
		int expectedRes=3;
		assertEquals(actualRes,expectedRes);
		
	}
	
	
	@Test
	public void test_AvailableChocieinRow_4()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
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
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		
		int actualRes = p.availableChoicesInRow(4);
		
		
		int expectedRes=2;
		assertEquals(actualRes,expectedRes);
		
	}
	
	
	@Test
	public void test_AvailableChocieinRow_5()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		
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
		
		PreferenceMatrix p = new PreferenceMatrix(preferenceList);
		
		p.Stage1();
		p.Stage2();
		p.Stage3();
		
		
		int actualRes = p.availableChoicesInRow(10);
		
		int expectedRes=2;
		assertEquals(actualRes,expectedRes);
		
	}
	
	
	@After
	public void TearDown()
	{
		sro.clearHallList();
		officeInstance.clearPersonList();
		office.clearStudentEligibleList();;
		
		
	}
	

}
