package roomSync;

public class ExNumberFormat extends Exception
{
	private static final long serialVersionUID = 1L;
	public ExNumberFormat ()
	{ 
		super("Wrong Number Input");
	}
	public ExNumberFormat(String message)
	{
		super(message);
	}
}
