package TestCases;
import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HallTesting_1 {

	SRO sro;
	
	@Before
	public void setup(){
		sro = SRO.getInstance();
		
	}
	
	@Test
	public void hallCreationTest() {
		//Check if the halls are being properly constructed
		
		
		
		int capacityHall10 = 20;
		int capacityHall4 = 50;
		
		
		sro.createHall("Hall10",capacityHall10);
		sro.createHall("Hall4",capacityHall4);
		
		int expectedCapacity = (capacityHall10+capacityHall4);
		int actualCapacity   = sro.getAvailableNoOfRooms();
		//Capacity of the entire residence == capacity [Hall10 + Hall4]
		assertEquals(  actualCapacity ,expectedCapacity  );
		}
	
	@Test
	public void hallUpdateTest(){
		
		
		
		int capacityHall11 = 30;
		int capacityHall6 = 60;
		
		sro.createHall("Hall11",capacityHall11);
		sro.createHall("Hall6",capacityHall6);
		
		//Update Hall capacity
		int newCapcityHall11 = capacityHall11 + 20; 
		sro.editHall(new Hall("Hall11",newCapcityHall11));
		
		int expectedCapacity = newCapcityHall11 + capacityHall6;
		int actualCapacity   = sro.getAvailableNoOfRooms();
		
		
		assertEquals(actualCapacity,expectedCapacity);
	}
	
	@Test
	public void hallUpdateUserErrorTest(){
		
		
		
		int capacityHall5 = 50;
		int capacityHall7 = 30;
		
		sro.createHall("Hall5",capacityHall5);
		sro.editHall(new Hall("Hall7",capacityHall7));
		
		System.out.println(sro.getAvailableNoOfRooms());
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall5+capacityHall7)  );
	}
	
	@Test
	public void removeHallTest(){
		
		
		
		int capacityHall10 = 30;
		int capacityHall2 = 60;
		
		sro.createHall("Hall10",capacityHall10);
		sro.createHall("Hall2",capacityHall2);
		
		sro.removeHall(new Hall("Hall10",10));
		
		System.out.println(sro.getAvailableNoOfRooms());
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall2)  );
		
	/*	sro.removeHall(new Hall("Hall2",10));
	*/}

	@Test
	public void setRoomOccupantsTest(){
	
	
		int capacityHall4 = 50;
		
		sro.createHall("Hall4",capacityHall4);
		Person A = new Person("A","2265","M","YYY");
		Person B = new Person("B","2167","M","YYY");
		sro.setRoomOccupants(A, B);
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall4-1)  );
		
}
	
	@Test
	public void attemptToCreateSameHallTest(){
	
		int capacityHall8 = 40;
		
		sro.createHall("Hall8",capacityHall8);
		sro.createHall("Hall8",capacityHall8+10);
		//second attempt to create hall1 not successful...
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall8)  );
		
	}
	
	@Test
	public void attemptToOverFillHall(){
		

		int capacityHall5 = 10;
		
		sro.createHall("Hall5",capacityHall5);
		Person A = new Person("A","2045","M","YYY");
		Person B = new Person("B","2967","M","YYY");
		Person C = new Person("C","2141","M","YYY");
		Person D = new Person("D","2781","M","YYY");
		Person E = new Person("E","20395","M","YYY");
		Person F = new Person("F","26567","M","YYY");
		Person G = new Person("G","28951","M","YYY");
		Person H = new Person("H","22561","M","YYY");
		Person I = new Person("I","31561","M","YYY");
		Person J = new Person("J","12961","M","YYY");
		
		sro.setRoomOccupants(A, B);
		sro.setRoomOccupants(C, D);
		sro.setRoomOccupants(E, F);
		sro.setRoomOccupants(G, H);
		sro.setRoomOccupants(I, J);
		
		assertEquals(  sro.getAvailableNoOfRooms(),(5)  );
			
	}
	
	@Test
	public void getAllHallResidents(){
		
	
		
		int capacityHall1 = 40;
		
		
		sro.createHall("Hall1",capacityHall1);
		Person A = new Person("A","2345","M","YYY");
		Person B = new Person("B","2567","M","YYY");
		Person C = new Person("C","2341","M","YYY");
		Person D = new Person("D","2561","M","YYY");
		Person E = new Person("E","22345","M","YYY");
		Person F = new Person("F","22567","M","YYY");
		Person G = new Person("G","22341","M","YYY");
		Person H = new Person("H","22561","M","YYY");
		sro.setRoomOccupants(A, B);
		sro.setRoomOccupants(C, D);
		sro.setRoomOccupants(E, F);
		sro.setRoomOccupants(G, H);
		sro.getallStudents();
		assertEquals(  sro.getAvailableNoOfRooms(),36  );
			
	}

	@After
	public void TearDown()
	{
		sro.clearHallList();
		
	}
	
}
