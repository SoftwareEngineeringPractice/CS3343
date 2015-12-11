package TestCases;

import java.util.ArrayList;

import roomSync.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Test_SRO {
	
	
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
	public void test_SRO_1()


	{
		
		
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		Hall hall3 = new Hall("Hall3",capacityHall3);
		Hall hall4 = new Hall("Hall4",capacityHall4);
		
		ArrayList<Hall> halls = new ArrayList<>();
		halls.add(hall3);
		halls.add(hall4);
		
		ArrayList<Hall> expectedHalls = sro.getHalls();
		assertEquals(halls,expectedHalls);
	
		
	}
	
	@Test
	public void test_SRO_2()


	{
		
		
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		int capacityHall5 = 30;
		int capacityHall6 = 10;
		
		
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		sro.createHall("Hall5",capacityHall5);
		sro.createHall("Hall6",capacityHall6);
		
		Hall hall3 = new Hall("Hall3",capacityHall3);
		Hall hall4 = new Hall("Hall4",capacityHall4);
		Hall hall5 = new Hall("Hall5",capacityHall5);
		Hall hall6 = new Hall("Hall6",capacityHall6);
		
		ArrayList<Hall> halls = new ArrayList<>();
		halls.add(hall3);
		halls.add(hall4);
		halls.add(hall5);
		halls.add(hall6);
		
		
		ArrayList<Hall> expectedHalls = sro.getHalls();
		assertEquals(halls,expectedHalls);
	
		
	}
	
	@Test
	public void test_SRO_3()


	{
		
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		int capacityHall5 = 30;
		int capacityHall6 = 10;
		int capacityHall7 = 30;
		int capacityHall8 = 20;
		
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		sro.createHall("Hall5",capacityHall5);
		sro.createHall("Hall6",capacityHall6);
		sro.createHall("Hall7",capacityHall7);
		sro.createHall("Hall8",capacityHall8);
		
		Hall hall1 = new Hall("Hall1",capacityHall1);
		Hall hall2 = new Hall("Hall2",capacityHall2);
		Hall hall3 = new Hall("Hall3",capacityHall3);
		Hall hall4 = new Hall("Hall4",capacityHall4);
		Hall hall5 = new Hall("Hall5",capacityHall5);
		Hall hall6 = new Hall("Hall6",capacityHall6);
		Hall hall7 = new Hall("Hall7",capacityHall7);
		Hall hall8 = new Hall("Hall8",capacityHall8);
		
		ArrayList<Hall> halls = new ArrayList<>();
		
		halls.add(hall1);
		halls.add(hall2);
		halls.add(hall3);
		halls.add(hall4);
		halls.add(hall5);
		halls.add(hall6);
		halls.add(hall7);
		halls.add(hall8);
		
		
		ArrayList<Hall> expectedHalls = sro.getHalls();
		assertEquals(halls,expectedHalls);
	
		
	}
	
	
	@Test
	public void test_SRO_4()


	{
		
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		int capacityHall5 = 30;
		int capacityHall6 = 10;
		int capacityHall7 = 30;
		int capacityHall8 = 20;
		
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		sro.createHall("Hall5",capacityHall5);
		sro.createHall("Hall6",capacityHall6);
		sro.createHall("Hall7",capacityHall7);
		sro.createHall("Hall8",capacityHall8);
		
		Hall hall1 = new Hall("Hall1",capacityHall1);
		Hall hall2 = new Hall("Hall2",capacityHall2);
		Hall hall3 = new Hall("Hall3",capacityHall3);
		Hall hall4 = new Hall("Hall4",capacityHall4);
		Hall hall5 = new Hall("Hall5",capacityHall5);
		Hall hall6 = new Hall("Hall6",capacityHall6);
		Hall hall7 = new Hall("Hall7",capacityHall7);
		Hall hall8 = new Hall("Hall8",capacityHall8);
		
		
		int expectedCapacity = capacityHall1+capacityHall2+capacityHall3+capacityHall4+capacityHall5+capacityHall6+capacityHall7+capacityHall8;
		int actualCapacity   = sro.getAvailableNoOfRooms();
	
		assertEquals(expectedCapacity,actualCapacity);
		
	}
	
	@Test
	public void test_SRO_5()


	{
		
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		
		
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		
		Hall hall1 = new Hall("Hall1",capacityHall1);
		Hall hall2 = new Hall("Hall2",capacityHall2);
		Hall hall3 = new Hall("Hall3",capacityHall3);
		Hall hall4 = new Hall("Hall4",capacityHall4);
		
		
	
		
		int expectedCapacity = capacityHall1+capacityHall2+capacityHall3+capacityHall4;
		int actualCapacity   = sro.getAvailableNoOfRooms();
	
		assertEquals(expectedCapacity,actualCapacity);
		
	}
	
	@Test
	public void test_SRO_6()


	{
		
		int capacityHall1 = 40;
		int capacityHall2 = 50;
		int capacityHall3 = 40;
		int capacityHall4 = 50;
		int capacityHall5 = 30;
		int capacityHall6 = 10;
		
		
		
		sro.createHall("Hall1",capacityHall1);
		sro.createHall("Hall2",capacityHall2);
		sro.createHall("Hall3",capacityHall3);
		sro.createHall("Hall4",capacityHall4);
		sro.createHall("Hall5",capacityHall5);
		sro.createHall("Hall6",capacityHall6);
		
		Hall hall1 = new Hall("Hall1",capacityHall1);
		Hall hall2 = new Hall("Hall2",capacityHall2);
		Hall hall3 = new Hall("Hall3",capacityHall3);
		Hall hall4 = new Hall("Hall4",capacityHall4);
		Hall hall5 = new Hall("Hall5",capacityHall5);
		Hall hall6 = new Hall("Hall6",capacityHall6);
		
		
		
		
		int expectedCapacity = capacityHall1+capacityHall2+capacityHall3+capacityHall4+capacityHall5+capacityHall6;
		int actualCapacity   = sro.getAvailableNoOfRooms();
	
		assertEquals(expectedCapacity,actualCapacity);
		
	}
	
	
	@After
	public void TearDown()
	{
		sro.clearHallList();
		officeInstance.clearPersonList();
		office.clearStudentEligibleList();;
		
		
	}
	
	
	

}
