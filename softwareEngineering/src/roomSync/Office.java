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
		int totalRooms  = sro.getAvailableNoOfRooms();
		int maleRooms   = totalRooms/2;
		int femaleRooms = totalRooms - maleRooms;
		
		if(maleRooms%2==1){
			maleRooms++;
			femaleRooms--;
		}
		
		//just to generate error
		
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
	
/*	public void setPreferenceList(ArrayList<Person> batch)
	{
		studentOffice.makePreferences(batch);
		//studentOffice.makePreferences(residenceEligiblePersonListFemale);
	}
	*/
	
	// Get the final paired male and females
	public void pairStudents()
	{
		/*ArrayList<Pair> malePairs   = pairMale();
		ArrayList<Pair> femalePairs = pairFemale();
		*/
		
		ArrayList<Pair> malePairs     = pair('M');
		ArrayList<Pair> femalePairs   = pair('F');
		for(Pair m: malePairs){
			
			sro.setRoomOccupants(m.getLeft(),m.getRight());
			residenceEligiblePersonListMale.remove(m.getLeft());
			residenceEligiblePersonListMale.remove(m.getRight());
			studentOffice.removeHallOccupants(m.getLeft());
			studentOffice.removeHallOccupants(m.getRight());
			
		}
		for(Pair fm: femalePairs){
			sro.setRoomOccupants(fm.getLeft(),fm.getRight());
			residenceEligiblePersonListFemale.remove(fm.getLeft());
			residenceEligiblePersonListFemale.remove(fm.getRight());
			studentOffice.removeHallOccupants(fm.getLeft());
			studentOffice.removeHallOccupants(fm.getRight());
			
		}
		
		
		System.out.println("remaining"+sro.getAvailableNoOfRooms());
		sro.getallStudents();
		studentOffice.printPersons();
		
	}
	
	/*//TODO naming has to be changed
	public ArrayList<Pair> pairMale()
	{
		ArrayList<Pair> finalPairs = new ArrayList<Pair>();
		int limit = 20;
		int maxBatchSize = 50;
		//if(residenceEligiblePersonListMale.size()>maxBatchSize)
		if(true)
		{
			int noOfBatches = residenceEligiblePersonListMale.size()/maxBatchSize;
			if(residenceEligiblePersonListMale.size() > noOfBatches*maxBatchSize)
			{
				noOfBatches++;
			}
			System.out.println("noOfBatches:"+noOfBatches);
			for(int i=0; i< noOfBatches; i++ )
			{
				ArrayList<Person> batch = new ArrayList<>();
				System.out.println("f:"+maxBatchSize*(i)+"t:"+(maxBatchSize*(i+1)-1));
				for(int j = maxBatchSize*(i); j < (maxBatchSize*(i+1)) && j<residenceEligiblePersonListMale.size(); j++)
				{
					batch.add(residenceEligiblePersonListMale.get(j));
				}	
					int k = 0;
					PreferenceMatrix p;
					ArrayList<Person> unPaired = batch;
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
						
						k++;
					}while(k<limit && unPaired.size()>0);
					
					
					// Only if after executing the preference Matrix for a given limit, we still have unPaired students (last resort)
					if(k >= limit && unPaired.size() > 0 )
					{
						ArrayList<Pair> unresolvedPairs = new ArrayList<>();
						for(int l = 0; l < unPaired.size(); l = l + 2)
						{
							Pair up = new Pair(unPaired.get(l),unPaired.get(l+1));
							unresolvedPairs.add(up);
							finalPairs.add(up);
						}
					}
				
			}
			
		}
		return finalPairs;
	}
	
	
	
	////////////////////~~~~~~~~~~~~~~~~~~~~~~~~
	
	
	public ArrayList<Pair> pairFemale()
	{
		ArrayList<Pair> finalPairs = new ArrayList<Pair>();
		int limit = 20;
		
		
		//
		
		int maxBatchSize = 50;
		if(residenceEligiblePersonListFemale.size()>maxBatchSize)
		{
			
			int noOfBatches = residenceEligiblePersonListFemale.size()/maxBatchSize;
			if(residenceEligiblePersonListFemale.size() > noOfBatches*maxBatchSize){
				noOfBatches++;
			}
			System.out.println("noOfBatches:"+noOfBatches);
			for(int i=0; i< noOfBatches; i++ )
			{
				ArrayList<Person> batch = new ArrayList<>();
				System.out.println("f:"+maxBatchSize*(i)+"t:"+(maxBatchSize*(i+1)-1));
				for(int j = maxBatchSize*(i); j < (maxBatchSize*(i+1)) && j<residenceEligiblePersonListFemale.size(); j++)
				{
					batch.add(residenceEligiblePersonListFemale.get(j));
					
				}	
					int k = 0;
					PreferenceMatrix p;
					ArrayList<Person> unPaired = batch;
					
					if(unPaired.size()%2==1){
						unPaired.remove(unPaired.get(unPaired.size()-1));
					}
					
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
						
						k++;
					}while(k<limit && unPaired.size()>0);
					
					
					// Only if after executing the preference Matrix for a given limit, we still have unPaired students (last resort)
					if(k >= limit && unPaired.size() > 0 )
					{
						ArrayList<Pair> unresolvedPairs = new ArrayList<>();
						for(int l = 0; l < unPaired.size(); l = l + 2)
						{
							Pair up = new Pair(unPaired.get(l),unPaired.get(l+1));
							unresolvedPairs.add(up);
							finalPairs.add(up);
						}
					}
				
					
					
					
					//~~~~~~~~~~~~~~~~~~~~~~~~~
					
				
				
				
			}
			
			
		}
		
		
		//
		
		
		
			
		return finalPairs;
	}
	
	*/
	
	public ArrayList<Pair> pair(char gender)
	{
		ArrayList<Person> eligiblePersonList;
		
		if(gender=='M'||gender=='m')
			eligiblePersonList = residenceEligiblePersonListMale;
		else
			eligiblePersonList = residenceEligiblePersonListFemale;
		
		
		ArrayList<Pair> finalPairs = new ArrayList<Pair>();
		int limit = 20;
		int maxBatchSize = 50;
		//if(residenceEligiblePersonListMale.size()>maxBatchSize)
		if(true)
		{
			int noOfBatches = eligiblePersonList.size()/maxBatchSize;
			if(eligiblePersonList.size() > noOfBatches*maxBatchSize)
			{
				noOfBatches++;
			}
			System.out.println("noOfBatches:"+noOfBatches);
			for(int i=0; i< noOfBatches; i++ )
			{
				ArrayList<Person> batch = new ArrayList<>();
				System.out.println("f:"+maxBatchSize*(i)+"t:"+(maxBatchSize*(i+1)-1));
				for(int j = maxBatchSize*(i); j < (maxBatchSize*(i+1)) && j<eligiblePersonList.size(); j++)
				{
					batch.add(eligiblePersonList.get(j));
				}	
					int k = 0;
					PreferenceMatrix p;
					ArrayList<Person> unPaired = batch;
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
						
						k++;
					}while(k<limit && unPaired.size()>0);
					
					
					// Only if after executing the preference Matrix for a given limit, we still have unPaired students (last resort)
					/*if(k >= limit && unPaired.size() > 0 )
					{
						ArrayList<Pair> unresolvedPairs = new ArrayList<>();
						for(int l = 0; l < unPaired.size(); l = l + 2)
						{
							Pair up = new Pair(unPaired.get(l),unPaired.get(l+1));
							unresolvedPairs.add(up);
							finalPairs.add(up);
						}
					}*/
				
			}
			
		}
		return finalPairs;
	}
	
	
	
	//////////////////~~~~~~~~~~~~~~~~~~~~~~~~~~
	
	/*
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
	}*/
}
