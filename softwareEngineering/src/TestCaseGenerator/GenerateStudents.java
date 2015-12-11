package TestCaseGenerator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class GenerateStudents {
	
	public static void makeTestCases() throws IOException
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Please input the file pathname for the Test Case you want to generate");
		String filepathname = in.nextLine();
		System.out.println();
		
		File testFile = new File(filepathname);
		if(!testFile.exists()) 
		{
			testFile.createNewFile();
			
			
		}
		else
		{
			System.out.println("Please choose a unique path name");
			return;
		}
		
		
		 
		BufferedWriter writer = new BufferedWriter(new FileWriter(filepathname));
		
		
		System.out.println("Please input the number of student instances you want to generate");
		int noOfStudents = in.nextInt();
		System.out.println("Please input the student ID you want to begin with [input = 5004],5005,5006...");
		int studentID = in.nextInt();
		System.out.println("Enter Number of Person Attributes");
		int noOfattributes = in.nextInt();
		
		
		
		int SID;
		String name;
		String testInstance;
		String attributes;
		
		Random rand = new Random();
		
		for(int i = 0; i < noOfStudents; i++)
		{
			SID  = studentID + i;
			name = "Student"+i;
			
			attributes="";
			for(int j = 0; j < noOfattributes; j++)
			{
				if(rand.nextFloat()<0.5)
					attributes = attributes  + "Y";
				else
					attributes = attributes  + "N";
				
				if(j < noOfattributes - 1)
					attributes = attributes + ",";
				
			}
			
			String gender;
			if(rand.nextFloat()<0.5){
				gender="|M|";
			}
			else{
				gender="|F|";
			}
				
			
			testInstance = name + "|" + SID + gender+ attributes;
			writer.write(testInstance);
			writer.newLine();
		}
		
		writer.close();
	}
	
	

}
