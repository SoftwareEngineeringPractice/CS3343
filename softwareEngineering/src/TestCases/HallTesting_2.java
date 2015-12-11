package TestCases;
import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HallTesting_2 {

	SRO sro;
	
	@Before
	public void setup(){
		sro = SRO.getInstance();
		
	}
	
	@Test
	public void hallCreationTest() {
		//Check if the halls are being properly constructed
		
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		
		
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		
		int expectedCapacity = (capacityHall3+capacityHall4);
		int actualCapacity   = sro.getAvailableNoOfRooms();
		//Capacity of the entire residence == capacity [Hall3 + Hall4]
		assertEquals(  actualCapacity ,expectedCapacity  );
		}
	
	@Test
	public void hallUpdateTest(){
		int capacityHall1 = 40;
		int capacityHall2 = 30;
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		
		//Update Hall capacity
		int newCapcityHall1 = capacityHall1 + 20; 
		sro.editHall(new Hall("Hall1",newCapcityHall1));
		
		int expectedCapacity = newCapcityHall1 + capacityHall2;
		int actualCapacity   = sro.getAvailableNoOfRooms();
		
		
		assertEquals(actualCapacity,expectedCapacity);
	}
	
	@Test
	public void hallUpdateUserErrorTest(){
		
		int capacityHall1 = 40;
		int capacityHall3 = 50;
		
		sro.createHall("Hall1",capacityHall1);
		sro.editHall(new Hall("Hall3",capacityHall3));
		
		
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1+capacityHall3)  );
	}
	
	@Test
	public void removeHallTest(){
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		
		sro.removeHall(new Hall("Hall1",10));
		
		
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall2)  );
		
	/*	sro.removeHall(new Hall("Hall2",10));
	*/}

	@Test
	public void setRoomOccupantsTest(){
	
		int capacityHall1 = 40;
		
		sro.createHall("Hall1",capacityHall1);
		Person A = new Person("A","2345","M","YYY");
		Person B = new Person("B","2567","M","YYY");
		sro.setRoomOccupants(A, B);
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1-1)  );
		
}
	
	@Test
	public void attemptToCreateSameHallTest(){
		int capacityHall1 = 40;
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall1",capacityHall1+10);
		//second attempt to create hall1 not successful...
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1)  );
		
	}
	
	@Test
	public void attemptToOverFillHall(){
		int capacityHall1 = 1;
		
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
		assertEquals(  sro.getAvailableNoOfRooms(),(0)  );
			
	}
	
	@Test
	public void getAllHallResidents(){
		int capacityHall1 = 20;
		
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
		assertEquals(  sro.getAvailableNoOfRooms(),16  );
			
	}

	@After
	public void TearDown()
	{
		sro.clearHallList();
		
	}
	
}
