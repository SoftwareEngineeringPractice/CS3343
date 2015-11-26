package roomSync;

public class CmdAddHall extends RecordedCommand {

	private String[] hall;
	
	@Override
	public void execute(String[] cmdParts) {
		
		// TODO Auto-generated method stub
		try {
			
			if(cmdParts.length < 2)
				throw new ExInsufficientCommandArgument();
			
			SRO sro = SRO.getInstance();
			sro.createHall(cmdParts[0],Integer.parseInt(cmdParts[1]));
			hall = cmdParts;
			addUndoCommand(this);
			clearRedoList();
			System.out.println("Hall added Successfully");
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Format");
		} catch (ExInsufficientCommandArgument e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void undoMe() {
		// TODO Auto-generated method stub
		try {
			SRO sro = SRO.getInstance();
			Hall h = new Hall( hall[0],Integer.parseInt(hall[1]) );
			sro.removeHall(h);
			addRedoCommand(this);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Format");
		}
	}

	@Override
	public void redoMe() {
		// TODO Auto-generated method stub
		try {
			SRO sro = SRO.getInstance();
			sro.createHall(hall[0],Integer.parseInt(hall[1]));
			addUndoCommand(this);
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			System.out.println("Wrong Format");
		}
	}

}
