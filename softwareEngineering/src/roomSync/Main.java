package roomSync;
import java.util.*;

@SuppressWarnings("unused")
public class Main
{

	public static void main(String [] args)
	{
		// TODO All this should be handled by Office
		StudentOffice officeInstance = StudentOffice.getOffice();
		officeInstance.makePersons();
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		office.setPreferenceList();
		office.pairStudents();
		
		
    }
	
}
