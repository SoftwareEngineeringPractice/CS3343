package TestCases;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import roomSync.*;

import org.junit.Test;

public class InterfaceTesting
{
	@Test
    public void unitTest_1() throws Exception
    {
		CmdAddPerson testAddPerson = new CmdAddPerson();
		String input[] = {"Student0" , "1000" , "M" , "N,Y,N"};
    	String expOuput = "\nPerson added Successfully\n";
    	setOutput();
    	testAddPerson.execute(input);
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
