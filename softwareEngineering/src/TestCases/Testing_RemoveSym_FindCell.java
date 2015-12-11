package TestCases;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class Testing_RemoveSym_FindCell {
	
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
	public void test_RemoveSym_FindCell_1()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		//p.displayMatrix();
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		p.removeSymmetrically(A,B);
		
		Cell actualCell = p.findCell(A, B);
		
		Cell ExpectedCell = new CellPreference(B,new CStateRejected());
		
		
		//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		

	}
	
	
	@Test
	public void test_RemoveSym_FindCell_2()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		//p.displayMatrix();
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		p.removeSymmetrically(C,D);
		
		Cell actualCell = p.findCell(C, D);
		
		Cell ExpectedCell = new CellPreference(D,new CStateRejected());
		
		
	//	System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		

	}
	
	
	@Test
	public void test_RemoveSym_FindCell_3()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		//p.displayMatrix();
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		p.removeSymmetrically(A,C);
		
		Cell actualCell = p.findCell(A, C);
		
		Cell ExpectedCell = new CellPreference(C,new CStateRejected());
		
		
		//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		

	}
	
	@Test
	public void test_RemoveSym_FindCell_4()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		//p.displayMatrix();
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		p.removeSymmetrically(B,D);
		
		Cell actualCell = p.findCell(B, D);
		
		Cell ExpectedCell = new CellPreference(D,new CStateRejected());
		
		
		//System.out.println(actualCell.getName()+" HI "+ actualCell.getStatusString());
		
		assertEquals(actualCell,ExpectedCell);
	
		
		
		

	}
	
	
	
	
}
