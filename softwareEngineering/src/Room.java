import java.util.*;


public class Room
{

	private RState roomStatus;
	private int roomID;
	private ArrayList<Person>roomMates=new ArrayList<>();
	
	public Room(int roomID,RState roomStatus)
	{
		this.roomID=roomID;
		this.roomStatus=roomStatus;
	}
	
	public ArrayList<Person>getRoomMates()
	{
		return roomMates;
	}
	
	public void addRoomMate(Person p)
	{
		roomMates.add(p);
	}
	
	public RState getState()
	{
		return roomStatus;
	}
	
	public void setState(RState newRoomStatus)
	{
		roomStatus=newRoomStatus;
	}
	
	//public String getRoomMates(){
	
		
}
