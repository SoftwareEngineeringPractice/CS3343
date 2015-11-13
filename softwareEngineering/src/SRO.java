import java.util.*;

public class SRO
{
	
	private static int tot_avai;	
	private static SRO sro= new SRO();
	private ArrayList<Hall>hall;
	
	private SRO()
	{
		hall = new ArrayList<Hall>();
	}
	
	public static SRO getInstance()
	{
		return sro;
	}

	private void addHall(Hall h)
	{
		if(hall.contains(h))
			System.out.println("Sorry. Hall already exists");
		else
			hall.add(h);
	}
	
	public void createHall(String id, int capacity)
	{
		Hall h = new Hall(id, capacity);
		this.addHall(h);
	}
	
	public void setRoomOccupants(Person a,Person b,Hall h)
	{	//Setting occupants to a room sequentially in a specified hall
		ArrayList<Room>r=h.getRoom();
		boolean isAvailable=false;
		if(hall.contains(h))
		{ 
			for(int i = 0; i < r.size(); i++)
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
		else
			System.out.println("Sorry, Hall does not exist");
		
	   if(!isAvailable)
		   System.out.println("Sorry, Hall is occupied");
	}
	
	public void setRoomOccupants(Person a, Person b)
	{	//Setting occupants to all SRO halls sequentially
		boolean roomsAvailable = false;
		
		for(Hall h:hall)
		{
			for(Room r:h.getRoom())
			{
				if(r.getState() instanceof RAvailable)
				{
					r.addRoomMate(a);
					r.addRoomMate(b);
					r.setState(new ROccupied());
					roomsAvailable=true;
					break;
				}
			}
			if(roomsAvailable)
				break;
		}
		
		if(!roomsAvailable)
			System.out.println("Sorry. All Halls are full");
	}
	
	public int getAvailableNoOfRooms()
	{
		for(Hall h: hall)
		{
			for(Room r: h.getRoom())
			{
				if(r.getState() instanceof RAvailable)
					tot_avai++;
			}
		}
		return tot_avai;
	}
	
	public void getallStudents()
	{
		for(Hall h:hall)
		{
			for(Room r: h.getRoom())
			{
				for(Person p:r.getRoomMates())
				{
					System.out.print(p.getName() + " ");
				}		
				if (r.getState() instanceof ROccupied)
				{
				    System.out.println();
				}
			}
		}
	}

}
