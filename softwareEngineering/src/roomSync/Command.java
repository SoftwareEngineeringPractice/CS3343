package roomSync;

public interface Command
{
	/**
	 * Interface function that is to be implemented in class that implement Command interface
	 * @param cmdParts
	 */
	void execute(String[] cmdParts);
}
