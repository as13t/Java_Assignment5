
public class CustomException extends Exception
{
	String errName;
	
	public CustomException()
	{
		super();
		errName = "error";
	}
	
	public CustomException(String err)
	{
		super(err);
		errName = err;
	}
	
	public String getError()
	{
		return errName;
	}
}
