
public class Checking extends Account{
	
	public Checking(Currency initialAmount) {
		super(initialAmount);
	}
	
	public void deposit(Currency amount) {
		balance=balance.add(amount);
	}
	
	public void withdraw(Currency amount) {
		balance=balance.subtract(amount);
	}
	
	public Currency getBalance() {
		return balance;
	}
	
	public String toString() {
		return "Balance in this Checking account: "+balance;
	}

}
