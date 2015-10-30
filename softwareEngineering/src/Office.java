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
		p.Stage2();
		p.Stage3();
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
		System.out.println("`````````````````````");
		studentOffice.makePreferences(ppl);
		PreferenceMatrix p2 = new PreferenceMatrix(ppl);
		p2.Stage1();
		p2.Stage2();
		p2.Stage3();
        ArrayList<Pair> pairs2 =  p2.getPaired();
		for(Pair pa : pairs2)
		{
			System.out.println(pa);
		}
		System.out.println("~~~~~~~~~~~~~~");
		
		ArrayList<Person> ppl2 =  p2.getUnPaired();
		for(Person pa1 : ppl2)
		{
			System.out.println(pa1.getName());
		}
		
	}
}
