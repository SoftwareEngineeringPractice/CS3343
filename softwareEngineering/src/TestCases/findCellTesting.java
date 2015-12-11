package TestCases;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class findCellTesting {
	
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
	public void test_findCell1()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		Cell actualCell = p.findCell(A, B);
		
		Cell ExpectedCell = new CellPreference(B,new CStateAvailable());
		
		
		assertEquals(actualCell,ExpectedCell);
	
	}
	
	
	
	
	@Test
	public void test_findCell2()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
	
		
		
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		Cell actualCell = p.findCell(C, D);
		
	
		
		
		
		Cell ExpectedCell = new CellPreference(D,new CStateAvailable());
		
		
		
		assertEquals(actualCell,ExpectedCell);
	
	}
	
	
	@Test
	public void test_findCell3()


	{
		
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		sro.createHall("Hall1",20);
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		
		
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		
		Cell actualCell = p.findCell(A, D);
		
	
		
		
		Cell ExpectedCell = new CellPreference(D,new CStateAvailable());
		
	
	assertEquals(actualCell,ExpectedCell);
	
	}
	
	
	
	
	@After
	public void TearDown()
	{
		sro.clearHallList();
		officeInstance.clearPersonList();
		office.clearStudentEligibleList();;
		
		
	}
	
}


