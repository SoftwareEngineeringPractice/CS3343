package roomSync;

public class CmdPrintNumberOfRoomsLeft implements Command {

	@Override
	public void execute(String[] cmdParts) {
		SRO sro = SRO.getInstance();
		sro.getAvailableNoOfRooms();

	}

}
