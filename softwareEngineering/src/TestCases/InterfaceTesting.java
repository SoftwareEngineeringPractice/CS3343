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
    public void AddHallTest_1() throws Exception
    {
		CmdAddHall testAddHall = new CmdAddHall();
		String input[] = {"Hall4","60"};
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
