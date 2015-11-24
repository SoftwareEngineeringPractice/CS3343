package roomSync;
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

		int n = 70;
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
		PreferenceMatrix p;
		int limit = 20;
		ArrayList<Person> unPaired = residenceEligiblePersonList; 
		
		int i = 0;
		
		do
		{
			studentOffice.makePreferences(unPaired);
			p = new PreferenceMatrix(unPaired);
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
			
			unPaired =  p.getUnPaired();
			for(Person pa1 : unPaired)
			{
				System.out.println(pa1.getName());
			}
			System.out.println("`````````````````````");
			
			i++;
		}while(i<limit && unPaired.size()>0);
		
		
		// Only if after executing the preference Matrix for a given limit, we still have unPaired students (last resort)
		if(i >= limit && unPaired.size() > 0 )
		{
			ArrayList<Pair> unresolvedPairs = new ArrayList<>();
			for(int j = 0; j < unPaired.size(); j = j + 2)
			{
				unresolvedPairs.add(new Pair(unPaired.get(j),unPaired.get(j+1)));
			}
			
		}
		
		
		
	}
}
