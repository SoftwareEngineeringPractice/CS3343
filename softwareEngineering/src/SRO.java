import java.util.*;


public class SRO
{
	
	private static int tot_avai;	
	private static SRO sro= new SRO();
	private ArrayList<Hall>hall;
	
	private SRO()
	{
		hall=new ArrayList<Hall>();
	}
	
	public static SRO getInstance()
	{
		return sro;
	}

	public void addHall(Hall h)
	{
		if(hall.contains(h))
			System.out.println("Sorry. Hall already exists");
		else
			hall.add(h);
	}
	
	public void setRoomOccupants(Person a,Person b,Hall h)
	{
		ArrayList<Room>r=h.getRoom();
		boolean isAvailable=false;
		if(hall.contains(h))
		{ 
			   for(int i=0;i<r.size();i++)
			   {
				    if(r.get(i).getState() instanceof RAvailable)
				    {
				    	r.get(i).addRoomMate(a);
						r.get(i).addRoomMate(b);
						r.get(i).setState(new ROccupied());
						isAvailable=true;
						break;
				   }
			  }
		}
		
		else if(!isAvailable)
			System.out.println("Sorry, Hall is occupied");
		
		else
			System.out.println("Sorry, Hall does not exist");
	}
	
	public int getAvailableNoOfRooms()
	{
		for(Hall h:hall)
		{
			for(Room r:h.getRoom())
				if(r.getState() instanceof RAvailable)
					tot_avai++;
		}
		return tot_avai++;
	}
	
	public void getallStudents()
	{
		for(Hall h:hall)
		{
			for(Room r:h.getRoom())
			{
				for(Person p:r.getRoomMates())
				{
					System.out.println(p.getName() + " ");
				}
			}
		}
	}

}
