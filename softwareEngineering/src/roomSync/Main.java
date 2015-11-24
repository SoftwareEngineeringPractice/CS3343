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
	/*
	public static void main(String[] args)
	{
		
		SRO s = SRO.getInstance();
		
		Person a=new Person("Aditya","ABC123");
		Person b=new Person("Shivam","ABC456");
		Person c=new Person("Vipul","DEF123");
		Person d=new Person("Dayle","DEF456");
		Person e=new Person("Panda","GHI123");
		Person f=new Person("Ronaldo","GHI456");
		
		Hall h= new Hall("Hall2");
		s.addHall(h);
		Hall h1=new Hall("Hall1");
		s.addHall(h1);
		
		
		RState rstate=new RAvailable();
		
		h.addRoom(new Room("101",rstate));
		h.addRoom(new Room("102",rstate));
		h.addRoom(new Room("103",rstate));	
		
		h1.addRoom(new Room("101",rstate));
		h1.addRoom(new Room("102",rstate));
		h1.addRoom(new Room("103",rstate));
		h1.addRoom(new Room("104",rstate));
		
		s.setRoomOccupants(a, b, h);		
		s.setRoomOccupants(c, d, h1);
		s.setRoomOccupants(e, f, h1);
		
		s.getallStudents();
		
		System.out.println(s.getAvailableNoOfRooms());
		h1.getHallResidents();
		h.getHallResidents();
		
	}
	*/
}
