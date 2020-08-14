
public class CD extends Account{
	
	private double rate;
	
	public CD(Currency initialAmount, double rate) {
		super(initialAmount);
		this.rate=rate;
	}
	
	public void deposit(Currency amount) throws InvalidDepositException{
		throw new InvalidDepositException();
	}
	
	public void withdraw(Currency amount) throws InvalidWithdrawException{
		throw new InvalidWithdrawException();
	}
	
	public Currency getBalance() {
		return balance;
	}
	
	public String toString() {
		return "The balance in this CD account: "+balance;
	}

}
