package roomSync;
import java.io.IOException;
import java.util.*;

@SuppressWarnings("unused")
public class Main
{

	public static void main(String [] args) throws NumberFormatException, IOException
	{
		
		/*
		// TODO All this should be handled by Office
		StudentOffice officeInstance = StudentOffice.getOffice();
		//To get data from the txt file
		officeInstance.makePersons();
		
		//  to create halls
		SRO sro = SRO.getInstance();
		sro.createHall("Hall1",40);
		sro.createHall("Hall2",50);
		System.out.println(sro.getAvailableNoOfRooms());
		//----------------------------------------------------
		
		Office office = Office.getOffice();
		//Setting the number of people that can fit in the res --> to a seperate arraylist (eligible to res)
		office.setEligiblePeople();
		office.pairStudents();
		
		//TODO implement sro.setRoomOccupants(Person a, Person b) or sro.setRoomOccupants(Person a, Person b, Hall h)
		*/
		DisplayScreen screen = new MainScreen();
		screen.screenDisplay();
		
    }
}
