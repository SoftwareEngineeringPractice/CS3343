package TestCases;

import static org.junit.Assert.*;

import org.junit.Test;

import roomSync.*;

public class OfficeTesting {

	@Test
	public void test() {
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.makePersons("./Student Test Cases/mixed2.txt");
		officeInstance.printPersons();
		officeInstance.makePreferences();
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",40);
		System.out.println(sro.getAvailableNoOfRooms());
		Office office = Office.getOffice();
		office.setEligiblePeople();
		
		office.pairStudents();
		sro.removeHall(new Hall("Hall1",10));
		
	}

	@Test
	public void test2() {
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.makePersons("./Student Test Cases/mixed.txt");
		officeInstance.printPersons();
		officeInstance.makePreferences();
		officeInstance.printPreferenceList();
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",233);
		System.out.println(sro.getAvailableNoOfRooms());
		Office office = Office.getOffice();
		office.setEligiblePeople();
		
		office.pairStudents();
		sro.removeHall(new Hall("Hall1",10));
		
	}

	@Test
	public void test3() {
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.makePersons("./Student Test Cases/mixed1.txt");
		officeInstance.printPersons();
		officeInstance.makePreferences();
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",233);
		System.out.println(sro.getAvailableNoOfRooms());
		Office office = Office.getOffice();
		office.setEligiblePeople();
		
		office.pairStudents();
		
		sro.removeHall(new Hall("Hall1",10));
		
	}
	

}
