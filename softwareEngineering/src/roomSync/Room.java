package roomSync;
import java.util.*;


public class Room
{

	private RState roomStatus;
	private String roomID;
	@SuppressWarnings("unused")
	private char roomGender;
	private ArrayList<Person> roomMates=new ArrayList<>();
	
	public Room(String roomID, char roomGender , RState roomStatus)
	{
		this.roomID = roomID;
		this.roomGender = roomGender;
		this.roomStatus = roomStatus;
	}
	
	public ArrayList<Person> getRoomMates()
	{
		return roomMates;
	}
	
	public void addRoomMate(Person p)
	{
		roomMates.add(p);
	}
	
	public String getRoomID()
	{
		return roomID;
	}
	
	/*public char getRoomGender()
	{
		return roomGender;
	}*/

	public RState getState()
	{
		return roomStatus;
	}
	
	public void setState(RState newRoomStatus)
	{
		roomStatus = newRoomStatus;
	}
	
	
		
}
