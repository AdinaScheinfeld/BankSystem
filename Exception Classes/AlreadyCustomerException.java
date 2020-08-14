
public class AlreadyCustomerException extends Exception{
	
	public String getMessage() {
		
		return "You are already a customer of this bank.";
	}

}
