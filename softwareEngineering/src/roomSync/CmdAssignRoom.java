package roomSync;

public class CmdAssignRoom implements Command
{

	@Override
	public void execute(String[] cmdParts)
	{
		Office office = Office.getOffice();
		//Setting the number of people that can fit in the res --> to a seperate arraylist (eligible to res)
		office.setEligiblePeople();
		office.pairStudents();
		System.out.print("\nRoom Assign Successful\n");
	}
}
