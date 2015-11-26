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
		
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",100);
		sro.createHall("Hall2",50);
		System.out.println(sro.getAvailableNoOfRooms());
		
		//Hall id = "Hall1" Hall Cap = 70
		
		Office office = Office.getOffice();
		office.setEligiblePeople();
		//office.setPreferenceList();
		office.pairStudents();
		
		//TODO implement sro.setRoomOccupants(Person a, Person b) or sro.setRoomOccupants(Person a, Person b, Hall h)
		
		
		
    }
	
}
