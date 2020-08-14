
public class AccountAlreadyExistsException extends Exception{
	
	public String getMessage() {
		return "You already have an account of that type open.";
	}

}
