import java.util.ArrayList;


public class Office
{
	private static Office office = new Office();
	private ArrayList<Person> residenceEligiblePersonList;
	//Only for testing, will be changed to available rooms
	
	private StudentOffice studentOffice = StudentOffice.getOffice();
	private SRO sro = SRO.getInstance();
	
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
		//int n = sro.getAvailableNoOfRooms();
		int n = 20;
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
		System.out.println("Post Stage 2================================");
		p.displayMatrix();
		p.Stage3();
        System.out.println("Post Stage 3================================");
		p.displayMatrix();
		System.out.println("================================");
		
		ArrayList<Pair> pairs =  p.getPaired();
		for(Pair pa : pairs)
		{
			System.out.println(pa);
		}
		System.out.println("~~~~~~~~~~~~~~");
		
		ArrayList<Person> ppl =  p.getUnPaired();
		for(Person pa1 : ppl)
		{
			System.out.println(pa1.getName());
		}
		
		
		//p.displayFinalResult();
		
	}
}
