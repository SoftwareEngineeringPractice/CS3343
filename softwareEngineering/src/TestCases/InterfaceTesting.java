package TestCases;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import roomSync.*;

import org.junit.Test;

public class InterfaceTesting
{
	@Test
    public void AddPersonTest_1() throws Exception
    {
		CmdAddPerson testAddPerson = new CmdAddPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
		String expOuput = "\nPerson added Successfully\n";
		setOutput();
    	testAddPerson.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void AddPersonTest_2() throws Exception
    {
		CmdAddPerson testAddPerson = new CmdAddPerson();
		String input[] = {"Student0" , "1000" };
    	String expOuput = "\nInsufficient Arguments\n";
    	setOutput();
    	testAddPerson.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void AddPersonTest_3() throws Exception
    {
		CmdAddPerson testAddPerson = new CmdAddPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
    	String expOuput = "\nUndo Successful\n";
    	testAddPerson.execute(input);
    	setOutput();
    	testAddPerson.undoMe();
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void AddPersonTest_4() throws Exception
    {
		CmdAddPerson testAddPerson = new CmdAddPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
    	String expOuput = "\nRedo Successful\n";
    	testAddPerson.execute(input);
    	testAddPerson.undoMe();
    	setOutput();
    	testAddPerson.redoMe();
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void EditPersonTest_1() throws Exception
    {
		CmdEditPerson testEditPerson = new CmdEditPerson();
		CmdAddPerson testAddPerson = new CmdAddPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
		String expOuput = "\nPerson added Successfully\n";
		testAddPerson.execute(input);
		setOutput();
    	testEditPerson.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
	 public void EditPersonTest_2() throws Exception
	 {
		CmdEditPerson testEditPerson = new CmdEditPerson();
		String input[] = {"Student0" , "1000" };
    	String expOuput = "\nInsufficient Arguments\n";
    	setOutput();
    	testEditPerson.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
	 public void EditPersonTest_3() throws Exception
	 {
		CmdEditPerson testEditPerson = new CmdEditPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
    	String expOuput = "\nUndo Successful\n";
    	testEditPerson.execute(input);
    	setOutput();
    	testEditPerson.undoMe();
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
	 public void EditPersonTest_4() throws Exception
	 {
		CmdEditPerson testEditPerson = new CmdEditPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
    	String expOuput = "\nRedo Successful\n";
    	testEditPerson.execute(input);
    	testEditPerson.undoMe();
    	setOutput();
    	testEditPerson.redoMe();
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void AddHallTest_1() throws Exception
    {
		CmdAddHall testAddHall = new CmdAddHall();
		String input[] = {"Hall5","60"};
    	String expOuput = "\nHall added Successfully\n";
    	setOutput();
    	testAddHall.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void AddHallTest_2() throws Exception
    {
		CmdAddHall testAddHall = new CmdAddHall();
		String input[] = {"Hall4"};
    	String expOuput = "\nInsufficient Arguments\n";
    	setOutput();
    	testAddHall.execute(input);
    	assertEquals(expOuput, getOutput());
    }

	@Test
    public void AddHallTest_3() throws Exception
    {
		CmdAddHall testAddHall = new CmdAddHall();
		String input[] = {"Student0" , "1000" };
    	String expOuput = "\nUndo Successful\n";
    	testAddHall.execute(input);
    	setOutput();
    	testAddHall.undoMe();
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void AddHallTest_4() throws Exception
    {
		CmdAddHall testAddHall = new CmdAddHall();
		String input[] = {"Student0" , "1000" };
    	String expOuput = "\nRedo Successful\n";
    	testAddHall.execute(input);
    	testAddHall.undoMe();
    	setOutput();
    	testAddHall.redoMe();
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void AddHallTest_5() throws Exception
    {
		CmdAddHall testAddHall = new CmdAddHall();
		String input[] = {"Hall5","a"};
    	String expOuput = "\nWrong Number Input\n";
    	setOutput();
    	testAddHall.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	
	@Test
    public void AssignRoom_1() throws Exception
    {
		String input[] ={};
		CmdAssignRoom testAssignRoom = new CmdAssignRoom();
    	String expOuput = "\nRoom Assign Successful\n";
    	setOutput();
    	testAssignRoom.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void EditHallTest_1() throws Exception
    {
		CmdEditHall testEditHall = new CmdEditHall();
		String input[] = {"Hall4","60"};
    	String expOuput = "\nHall added Successfully\n";
    	setOutput();
    	testEditHall.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void EditHallTest_2() throws Exception
    {
		CmdEditHall testEditHall = new CmdEditHall();
		String input[] = {"Hall4"};
    	String expOuput = "\nInsufficient Arguments\n";
    	setOutput();
    	testEditHall.execute(input);
    	assertEquals(expOuput, getOutput());
    }

	@Test
    public void EditHallTest_3() throws Exception
    {
		CmdEditHall testEditHall = new CmdEditHall();
		String input[] = {"Student0" , "1000" };
    	String expOuput = "\nUndo Successful\n";
    	testEditHall.execute(input);
    	setOutput();
    	testEditHall.undoMe();
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void EditHallTest_4() throws Exception
    {
		CmdEditHall testEditHall = new CmdEditHall();
		String input[] = {"Student0" , "1000" };
    	String expOuput = "\nRedo Successful\n";
    	testEditHall.execute(input);
    	testEditHall.undoMe();
    	setOutput();
    	testEditHall.redoMe();
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void EditHallTest_5() throws Exception
    {
		CmdEditHall testEditHall = new CmdEditHall();
		String input[] = {"Hall7","a"};
    	String expOuput = "\nFor input string: \"a\"\n";
    	setOutput();
    	testEditHall.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void NumberOfRoomsLeft_1() throws Exception
    {
		CmdPrintNumberOfRoomsLeft room = new CmdPrintNumberOfRoomsLeft();
		String input[]={};
    	String expOuput = "";// no rooms have been added thus the resultant value is empty string
    	setOutput();
    	room.execute(input);
    	assertEquals(expOuput, getOutput());
    }
	
	@Test
    public void printRoomResult_1() throws Exception
    {
		CmdPrintResult room = new CmdPrintResult();
		String input[]={};
    	String expOuput = "List of all Persons:\nStudent0\nM\n	 - Smoker	 - false\n	 - Alcoholic	 - true\n	 - Night Owl	 - false\n";
    	setOutput();
    	room.execute(input);
    	assertEquals(expOuput, getOutput());
    }

	
    PrintStream oldPrintStream;
    ByteArrayOutputStream bos;
    private void setOutput() throws Exception
    {
        oldPrintStream = System.out;
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
    }

    private String getOutput()
    {
        System.setOut(oldPrintStream);
        return bos.toString();
    }
}
