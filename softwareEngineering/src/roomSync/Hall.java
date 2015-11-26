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
	
	public Hall(String hallID, int noOfDoubleRooms)
	{
		this.hallID = hallID;
		this.noOfDoubleRooms = noOfDoubleRooms;
		
		for(int i = 1; i <= noOfDoubleRooms; i += 2)
		{
			String roomSequence = String.format("%03d", i);
			this.addRoom(new Room(roomSequence, 'M' , new RAvailable()));
			this.addRoom(new Room(roomSequence, 'F' , new RAvailable()));
		}
	}
	
	private void addRoom(Room r)
	{
		rooms.add(r);	
	}
	
	public void getHallResidents()
	{
		System.out.print(hallID + " has the following occupants: ");
		for(Room r:rooms)
		{
			if(r.getState() instanceof ROccupied)
			{
				for(Person p:r.getRoomMates())
					System.out.print(p.getName() + "(" + p.getID() + ")" + " ");
			}		
		}
		System.out.println();
	}
}
