package roomSync;
import java.util.ArrayList;

public class Hall
{
	
	private String hallID;
	private int noOfDoubleRooms;
	private ArrayList<Room>rooms=new ArrayList<>();
	
	public ArrayList<Room>getRoom()
	{
		return rooms;
	}
	
	
	public int getNoOfDoubleRooms() {
		return noOfDoubleRooms;
	}



	public Hall(String hallID, int noOfDoubleRooms)
	{
		this.hallID = hallID;
		this.noOfDoubleRooms = noOfDoubleRooms;
		
		for(int i = 1; i <= noOfDoubleRooms; i += 2)
		{
			String roomSequence = String.format("%03d", i);
			this.addRoom(new Room(roomSequence, 'M' , new RAvailable()));
			roomSequence = String.format("%03d", i+1);
			
			this.addRoom(new Room(roomSequence, 'F' , new RAvailable()));
		}
	}
	
	private void addRoom(Room r)
	{
		rooms.add(r);	
	}
	
	public String getHallID()
	{
		return hallID;
	}
	
	
	@Override
	public boolean equals(Object h1)
	{
		Hall h = (Hall) h1;
		if(h.getHallID().equals(this.hallID))
			return true;
		return false;
	}
	
	
	public void getHallResidents()
	{
		System.out.println(hallID + " has the following occupants: ");
		for(Room r:rooms)
		{
			if(r.getState() instanceof ROccupied)
			{
				for(Person p:r.getRoomMates())
					System.out.print(p.getName() + "(" + r.getRoomID() + ")" + " ");
				System.out.println();
			}		
		}
		System.out.println();
	}
	

}
