import java.util.ArrayList;


public class Office {
	private static Office office = new Office();
	private ArrayList<Person> residenceEligiblePersonList;
	//Only for testing, will be changed to available rooms
	public static int n = 4;
	
	private StudentOffice studentOffice = StudentOffice.getOffice();
	
	
	private Office()
	{
		residenceEligiblePersonList = new ArrayList<>();
	}	
	public static Office getOffice()
	{
		return office;
	}
	
	public void setEligiblePeople()
	{
		ArrayList<Person> personList = studentOffice.getPersonList();
		for(Person p: personList)
		{
			//Current rule: FCFS
			if(personList.indexOf(p) < n)
			{
				residenceEligiblePersonList.add(p);
			}
		}
	}
	
	public void setPreferenceList()
	{
		studentOffice.makePreferences(residenceEligiblePersonList);
	}
	//TODO naming has to be changed
	public void pairStudents()
	{
		PreferenceMatrix p = new PreferenceMatrix(residenceEligiblePersonList);
		
		p.Stage1();
		p.displayMatrix();
		System.out.println("================================");
		p.Stage2();
		p.displayMatrix();
		p.Stage3();
        System.out.println("================================");
		p.displayMatrix();
		System.out.println("================================");
		p.displayFinalResult();
		
	}
}
