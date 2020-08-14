
public abstract class Account {
	
	protected Currency balance;
	
	public Account(Currency initialDeposit) {
		balance=initialDeposit;
	}
	
	public abstract void deposit(Currency money) throws InvalidDepositException;
	
	public abstract void withdraw(Currency money) throws InvalidWithdrawException;
	
	public abstract Currency getBalance();
	
	public abstract String toString();

}
