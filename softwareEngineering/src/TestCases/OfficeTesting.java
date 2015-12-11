package TestCases;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import roomSync.*;

public class OfficeTesting {

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
	public void testPreferences(){
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
		PreferenceMatrix e = new PreferenceMatrix(expected);
		
		
		assertArrayEquals(p.getMatrix(),expected);
		
	}
	
	
	@Test
	public void testEligibleStudentsMale() {
		officeInstance.makePersons("./Student Test Cases/mixed2.txt");
		officeInstance.makePreferences();
		sro.createHall("Hall1",4);
		office.setEligiblePeople();
		
		ArrayList<Person> eligibleMale = office.getEligibleMaleList();
		
		ArrayList<Person> expectedMaleEligibleList = new ArrayList<>();
		expectedMaleEligibleList.add(new Person("Student3","1003","M","YYY")); 
		expectedMaleEligibleList.add(new Person("Student4","1004","M","YYY"));
		assertEquals(expectedMaleEligibleList,eligibleMale);
}

	
	@Test
	public void testEligibleStudentsFemale() {
		officeInstance.makePersons("./Student Test Cases/mixed2.txt");
		officeInstance.makePreferences();
		sro.createHall("Hall1",4);
		office.setEligiblePeople();
		
		ArrayList<Person> eligibleMale = office.getEligibleFemaleList();
		
		ArrayList<Person> expectedMaleEligibleList = new ArrayList<>();
		expectedMaleEligibleList.add(new Person("Student0","1000","F","YYY")); 
		expectedMaleEligibleList.add(new Person("Student1","1001","F","YYY"));
		assertEquals(expectedMaleEligibleList,eligibleMale);
}

	@Test
	public void areAllotedPairsAsExpected() {
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.makePersons("./Student Test Cases/mixed2.txt");
		officeInstance.makePreferences();
		sro.createHall("Hall1",20);
		Office office = Office.getOffice();
		office.setEligiblePeople();
		
		ArrayList<Pair> expectedResult = new ArrayList<>();
		
		expectedResult.add(new Pair(new Person("Student7","1007","M","YYY"),new Person("Student8","1008","M","YYY")));
		expectedResult.add(new Pair(new Person("Student3","1003","M","YYY"),new Person("Student4","1004","M","YYY")));
		expectedResult.add(new Pair(new Person("Student0","1000","F","YYY"),new Person("Student9","1009","F","YYY")));
		expectedResult.add(new Pair(new Person("Student1","1001","F","YYY"),new Person("Student2","1002","F","YYY")));
		expectedResult.add(new Pair(new Person("Student5","1005","F","YYY"),new Person("Student6","1006","F","YYY")));
		
		
		
		office.pairStudents();
		ArrayList<Pair> actualResult = new ArrayList<>();
		
		ArrayList<Hall> hall  = sro.getHalls();
		for(Hall h:hall){
			ArrayList<Room> rooms = h.getRoom();
			for(Room r:rooms){
				ArrayList<Person> p = r.getRoomMates();
				if(r.getState() instanceof ROccupied)
					actualResult.add(new Pair(p.get(0),p.get(1)));
			}

		}
		assertEquals(expectedResult,actualResult);

	}

	@Test
	public void unAllotedPeopleCheck() {
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.makePersons("./Student Test Cases/mixed2.txt");
		sro.createHall("Hall1",4);
		Office office = Office.getOffice();
		office.setEligiblePeople();
		
		ArrayList<Person> expectedResult = new ArrayList<>();
		
		expectedResult.add(new Person("Student7","1007","M","YYY"));
		expectedResult.add(new Person("Student8","1008","M","YYY"));
		
		
		
		office.pairStudents();
		office.setEligiblePeople();
		
		ArrayList<Person> actualResult = office.getEligibleMaleList();
		
		assertEquals(expectedResult,actualResult);
			
	}
	
	@After
	public void TearDown()
	{
		sro.clearHallList();
		officeInstance.clearPersonList();
		office.clearStudentEligibleList();;
		
		
	}

}
