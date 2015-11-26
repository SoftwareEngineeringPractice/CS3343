package roomSync;

public class ExInsufficientCommandArgument extends Exception {

	private static final long serialVersionUID = 1L;
	public ExInsufficientCommandArgument()
	{ 
		super("Insufficient Arguments");
	}
	public ExInsufficientCommandArgument(String message)
	{
		super(message);
	}
}
