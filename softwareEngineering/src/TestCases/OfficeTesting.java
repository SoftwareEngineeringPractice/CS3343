package TestCases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import roomSync.*;

public class OfficeTesting {

	
	@Test
	public void testPreferences(){
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",20);
		Office office = Office.getOffice();
		office.setEligiblePeople();
		officeInstance.makePreferences(office.getEligibleMaleList());
		PreferenceMatrix p = new PreferenceMatrix(office.getEligibleMaleList());
		p.displayMatrix();
		sro.removeHall(new Hall("Hall1",10));
		
		Person A = new Person("A","1038","M","YYY");
		Person B = new Person("B","1039","M","YYY");
		Person C = new Person("C","1040","M","YYY");
		Person D = new Person("D","1041","M","YYY");
		Person E = new Person("E","1042","M","YYY");
		Person F = new Person("F","1043","M","YYY");
		Person G = new Person("G","1044","M","YYY");
		Person H = new Person("H","1045","M","YYY");
		Person I = new Person("I","1046","M","YYY");
		Person J = new Person("J","1047","M","YYY");
		
		Cell[][] expected = new Cell[][]{
				  { new CellSubject(A), new CellPreference(H), new CellPreference(C), new CellPreference(G), new CellPreference(J), new CellPreference(B),new CellPreference(D),new CellPreference(E),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(B), new CellPreference(C), new CellPreference(F), new CellPreference(G), new CellPreference(J), new CellPreference(A),new CellPreference(D),new CellPreference(E),new CellPreference(H),new CellPreference(I) },
				  { new CellSubject(C), new CellPreference(G), new CellPreference(J), new CellPreference(A), new CellPreference(B), new CellPreference(H),new CellPreference(I),new CellPreference(F),new CellPreference(D),new CellPreference(E) },
				  { new CellSubject(D), new CellPreference(E), new CellPreference(F), new CellPreference(A), new CellPreference(B), new CellPreference(H),new CellPreference(I),new CellPreference(C),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(E), new CellPreference(D), new CellPreference(F), new CellPreference(A), new CellPreference(B), new CellPreference(H),new CellPreference(I),new CellPreference(C),new CellPreference(G),new CellPreference(J) },
				  { new CellSubject(F), new CellPreference(B), new CellPreference(D), new CellPreference(E), new CellPreference(I), new CellPreference(C),new CellPreference(G),new CellPreference(J),new CellPreference(A),new CellPreference(H) },
				  { new CellSubject(G), new CellPreference(C), new CellPreference(J), new CellPreference(A), new CellPreference(B), new CellPreference(H),new CellPreference(I),new CellPreference(F),new CellPreference(D),new CellPreference(E) },
				  { new CellSubject(H), new CellPreference(A), new CellPreference(C), new CellPreference(G), new CellPreference(J), new CellPreference(B),new CellPreference(D),new CellPreference(E),new CellPreference(I),new CellPreference(F) },
				  { new CellSubject(I), new CellPreference(C), new CellPreference(F), new CellPreference(G), new CellPreference(J), new CellPreference(A),new CellPreference(B),new CellPreference(D),new CellPreference(E),new CellPreference(H) },
				  { new CellSubject(J), new CellPreference(C), new CellPreference(G), new CellPreference(A), new CellPreference(B), new CellPreference(H),new CellPreference(I),new CellPreference(F),new CellPreference(D),new CellPreference(E)}
				  
		};
		System.out.println("---");
		PreferenceMatrix e = new PreferenceMatrix(expected);
		e.displayMatrix();//[2]	   

		
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	
	
	//@Test
	public void testPersonCreation(){
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.clearPersonList();
		officeInstance.makePersons("./Student Test Cases/1am.txt");
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",8);
		System.out.println(sro.getAvailableNoOfRooms());
		Office office = Office.getOffice();
		office.setEligiblePeople();
		ArrayList<Person> eligible = office.getEligibleMaleList();
		for(Person p: eligible){
			System.out.println(p);
		}
		sro.removeHall(new Hall("Hall1",10));
	}
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
