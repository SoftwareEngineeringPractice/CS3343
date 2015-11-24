package TestCases;
import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.*;

public class test1 {

	StudentOffice studentOfficeInstance;
	Office office;
	
	@Before
	public void setup()
	{
		studentOfficeInstance = StudentOffice.getOffice();
		studentOfficeInstance.makePersons("./Student Test Cases/test1.txt");
		office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		
		
		
	}
	
	
	@Test
	public void test() {
		ArrayList<Person> eligibleList = office.getEligiblePeople();
		Person p1 = eligibleList.get(0);
		Person p2 = eligibleList.get(1);
		studentOfficeInstance.makePreferences(eligibleList);
		PreferenceMatrix p = new PreferenceMatrix(eligibleList);
		PreferenceMatrix ptest = new PreferenceMatrix(eligibleList);
		ptest.findCell(p1, p2).reject();
		ptest.findCell(p2, p1).reject();
		
		
		p.removeSymmetrically(p1,p2);
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		p.displayMatrix();
		//assertArrayEquals(ptest,p);
	}

}
