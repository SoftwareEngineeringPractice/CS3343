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
    	class StubMainScreen extends MainScreen
		{
			//Overwrite the class functions
    		@Override
			public int getInt()
			{
    			return 5;
			}
		}
    	setOutput();
    	DisplayScreen stub = new StubMainScreen();
    	stub.screenDisplay();
    	String expOuput = "Main Screen \n" + 
    					"1.Student \n" +
						"2.SRO \n" +
						"3.Backend \n" +
						"4.Exit \n" +
						"Input: " +
						"Wrong input.. Program Terminated" +
						"";
    	assertEquals(expOuput, getOutput());
    }
	@Test
    public void unitTest_2() throws Exception
    {
    	class StubMainScreen extends MainScreen
		{
			//Overwrite the class functions
    		@Override
			public int getInt()
			{
    			return 5;
			}
		}
    	setOutput();
    	DisplayScreen stub = new StubMainScreen();
    	stub.screenDisplay();
    	assertEquals("Wrong input.. Program Terminated", getOutput());
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
