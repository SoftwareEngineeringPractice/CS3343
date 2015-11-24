package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class test1 {

	StudentOffice studentOfficeInstance;
	Office office;
	PreferenceMatrix p;
	PreferenceMatrix ptest;
	ArrayList<Person> eligibleList;
	
	@Before
	public void setup()
	{
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/test1.txt");
		office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		eligibleList = office.getEligibleMaleList();
		studentOfficeInstance.makePreferences(eligibleList);
		p = new PreferenceMatrix(eligibleList);
		ptest = p;
		
		
		
	}
	
	
	@Test
	public void test() {
		Person p1 = eligibleList.get(0);
		Person p2 = eligibleList.get(1);
		
		ptest.findCell(p1, p2).reject();
		ptest.findCell(p2, p1).reject();
		
		
		p.removeSymmetrically(p1,p2);
		assertArrayEquals(ptest.getMatrix(),p.getMatrix());
		
	}

}
