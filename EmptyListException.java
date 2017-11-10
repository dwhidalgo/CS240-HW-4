@SuppressWarnings("serial")
public class EmptyListException extends Exception
{
	private static final String message = "The list is empty.";
	
	public EmptyListException()
	{
		super(message);
	}
}