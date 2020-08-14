
public class InvalidWithdrawException extends Exception{
	
	public String getMessage() {
		return "You cannot withdraw money from that account.";
	}

}
