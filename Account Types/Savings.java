
public class Savings extends Account{
	
	private double rate;
	
	public Savings(Currency initialAmount, double rate) {
		super(initialAmount);
		this.rate=rate;
	}
	
	public void deposit(Currency amount) {
		balance=balance.add(amount);
	}
	
	public void withdraw(Currency amount) {
		balance=balance.subtract(amount);
	}
	
	public Currency getBalance() {
		return balance.add(new Currency((int)(balance.getValue()*rate)));
	}
	
	public String toString() {
		return "The amount in the Savings account: "+balance;
	}

}
