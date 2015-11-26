package roomSync;
import java.util.ArrayList;


public class Office
{
	private static Office office = new Office();
	//Person List for all Males
	private ArrayList<Person> residenceEligiblePersonListMale;
	//Person List for all Females
	private ArrayList<Person> residenceEligiblePersonListFemale;
	//Only for testing, will be changed to available rooms
	
	private StudentOffice studentOffice = StudentOffice.getOffice();
	private SRO sro = SRO.getInstance();
	
	private Office()
	{
		residenceEligiblePersonListMale = new ArrayList<>();
		residenceEligiblePersonListFemale = new ArrayList<>();
	}
	
	
	public static Office getOffice()
	{
		return office;
	}
	
	public ArrayList<Person> getEligibleMaleList()
	{
		return residenceEligiblePersonListMale;
	}
	
	public ArrayList<Person> getEligibleFemaleList()
	{
		return residenceEligiblePersonListFemale;
	}
	
	public void setEligiblePeople()
	{
		//34 Males and 34 Females
		int totalRooms  = sro.getAvailableNoOfRooms();
		int maleRooms   = totalRooms/2;
		int femaleRooms = totalRooms - maleRooms;
		System.out.println("M"+maleRooms+" " +"F"+femaleRooms);
		setEligibleMale(maleRooms);
		setEligibleFemale(femaleRooms);
	}
	
	public void setEligibleMale(int cap)
	{
		ArrayList<Person> personList = studentOffice.getPersonList();

		//34 Males and 34 Females
		int n = 0;
		for(Person p: personList)
		{
			//Current rule: FCFS
			if(p.getSex() == 'M' && n < cap)
			{
				n++;
				residenceEligiblePersonListMale.add(p);
			}
		}
	}
	
	
	
	
	
	
	public void setEligibleFemale(int cap)
	{
		ArrayList<Person> personList = studentOffice.getPersonList();

		//34 Males and 34 Females
		int n = 0;
		for(Person p: personList)
		{
			//Current rule: FCFS
			if(p.getSex() == 'F' && n < cap)
			{
				n++;
				residenceEligiblePersonListFemale.add(p);
			}
		}
	}
	
	public void setPreferenceList()
	{
		studentOffice.makePreferences(residenceEligiblePersonListMale);
		studentOffice.makePreferences(residenceEligiblePersonListFemale);
	}
	
	public void pairStudents()
	{
		ArrayList<Pair> malePairs   = pairMale();
		ArrayList<Pair> femalePairs = pairFemale();;
		
	}
	
	//TODO naming has to be changed
	public ArrayList<Pair> pairMale()
	{
		ArrayList<Pair> finalPairs = new ArrayList<Pair>();
		PreferenceMatrix p;
		int limit = 20;
		ArrayList<Person> unPaired = residenceEligiblePersonListMale; 
		
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
				finalPairs.add(pa);
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
				Pair up = new Pair(unPaired.get(j),unPaired.get(j+1));
				unresolvedPairs.add(up);
				finalPairs.add(up);
			}
		}
		
		return finalPairs;
	}
	
	//TODO naming has to be changed
	public ArrayList<Pair> pairFemale()
	{
		ArrayList<Pair> finalPairs = new ArrayList<Pair>();
		PreferenceMatrix p;
		int limit = 20;
		ArrayList<Person> unPaired = residenceEligiblePersonListFemale; 
		
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
				finalPairs.add(pa);
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
				Pair up = new Pair(unPaired.get(j),unPaired.get(j+1));
				unresolvedPairs.add(up);
				finalPairs.add(up);
			}
		}
		
		return finalPairs;
	}
}
