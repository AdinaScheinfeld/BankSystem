
public class NotACustomerException extends Exception{
	
	public String getMessage() {
		return "You are not a customer of this bank.";
	}

}
