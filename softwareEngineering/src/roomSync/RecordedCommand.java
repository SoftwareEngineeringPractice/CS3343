package roomSync;


import java.util.*;
public abstract class RecordedCommand implements Command
{
	/* 2 abstract methods for subclass  to implement*/
	public abstract void undoMe();
	public abstract void redoMe();
	
	//undo list and re-do list
	private static ArrayList<RecordedCommand> undoList=new ArrayList<>();
	private static ArrayList<RecordedCommand> redoList=new ArrayList<>();
	
	//Adding command to the list
	protected static void addUndoCommand(RecordedCommand cmd) {undoList.add(cmd);}
	protected static void addRedoCommand(RecordedCommand cmd) {redoList.add(cmd);}
	
	//clear re-do list
	protected static void clearRedoList() {redoList.clear();}
	
	//carry out undo/re-do
	public static void undoOneCommand()
	{
		if(undoList.size()<1)
			System.out.println("Nothing to undo.");
		else
			undoList.remove(undoList.size()-1).undoMe();
	}
	public static void redoOneCommand()
	{
		if(redoList.size()<1)
			System.out.println("Nothing to redo.");
		else
			redoList.remove(redoList.size()-1).redoMe();
	}
}
