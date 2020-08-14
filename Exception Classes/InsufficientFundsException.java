
public class InsufficientFundsException extends Exception{
	
	public String getMessage() {
		return "You do not have sufficient funds in that account to withdraw that amount.";
	}

}
