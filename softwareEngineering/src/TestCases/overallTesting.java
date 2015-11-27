package TestCases;
import roomSync.*;

import static org.junit.Assert.*;

import org.junit.Test;

public class overallTesting {

	@Test
	public void hallCreationTest() {
		//Check if the halls are being properly constructed
		SRO sro = SRO.getInstance();
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		
		
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		System.out.println(sro.getAvailableNoOfRooms());
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall3+capacityHall4)  );
		sro.removeHall(new Hall("Hall3",10));
		sro.removeHall(new Hall("Hall4",10));
	}
	
	@Test
	public void hallUpdateTest(){
		SRO sro = SRO.getInstance();
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		
		sro.editHall(new Hall("Hall1",capacityHall1+20));
		
		System.out.println(sro.getAvailableNoOfRooms());
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1+capacityHall2+20)  );
		sro.removeHall(new Hall("Hall1",10));
		sro.removeHall(new Hall("Hall2",10));
	}
	
	@Test
	public void hallUpdateUserErrorTest(){
		SRO sro = SRO.getInstance();
		int capacityHall1 = 40;
		int capacityHall3 = 50;
		
		sro.createHall("Hall1",capacityHall1);
		
		sro.editHall(new Hall("Hall3",capacityHall3));
		
		System.out.println(sro.getAvailableNoOfRooms());
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1+capacityHall3)  );
		sro.removeHall(new Hall("Hall1",10));
		
		sro.removeHall(new Hall("Hall3",10));
	}
	
	@Test
	public void removeHallTest(){
		SRO sro = SRO.getInstance();
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		
		sro.removeHall(new Hall("Hall1",10));
		
		System.out.println(sro.getAvailableNoOfRooms());
		
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall2)  );
		
		sro.removeHall(new Hall("Hall2",10));
	}

	@Test
	public void setRoomOccupantsTest(){
		SRO sro = SRO.getInstance();
		int capacityHall1 = 40;
		
		sro.createHall("Hall1",capacityHall1);
		Person A = new Person("A","2345","M","YYY");
		Person B = new Person("B","2567","M","YYY");
		sro.setRoomOccupants(A, B);
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1-1)  );
		
		
		sro.removeHall(new Hall("Hall1",10));
	}
	
	@Test
	public void attemptToCreateSameHallTest(){
		SRO sro = SRO.getInstance();
		int capacityHall1 = 40;
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall1",capacityHall1+10);
		//second attempt to create hall1 not successful...
		assertEquals(  sro.getAvailableNoOfRooms(),(capacityHall1)  );
		
		
		sro.removeHall(new Hall("Hall1",10));
	}
	
	@Test
	public void attemptToOverFillHall(){
		SRO sro = SRO.getInstance();
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
			
		sro.removeHall(new Hall("Hall1",10));
	}
	
	@Test
	public void getAllHallResidents(){
		SRO sro = SRO.getInstance();
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
			
		sro.removeHall(new Hall("Hall1",10));
	}
}
