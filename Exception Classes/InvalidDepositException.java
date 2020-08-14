
public class InvalidDepositException extends Exception{
	
	public String getMessage() {
		return "You cannot deposit money into that account.";
	}

}
