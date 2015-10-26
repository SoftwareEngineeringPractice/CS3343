import java.util.*;

public class Hall
{
	private String hallID;
	private ArrayList<Room>rooms=new ArrayList<>();
	
	public ArrayList<Room>getRoom()
	{
		return rooms;
	}
	
	public Hall(String hallID)
	{
		this.hallID=hallID;
	}
	
	public void addRoom(Room r)
	{
		rooms.add(r);	
	}
	
}
