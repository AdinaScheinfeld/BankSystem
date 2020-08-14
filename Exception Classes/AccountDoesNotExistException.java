
public class AccountDoesNotExistException extends Exception{
	
	public String getMessage() {
		return "You do not have an account of that type.";
	}

}
