
public class Customer {
	
	private String first, last;
	private int numAccounts;
	private Account[] accounts;
	
	public Customer(String first, String last) {
		this.first=first;
		this.last=last;
		numAccounts=0;
		accounts=new Account[3];
	}
	
	public void addAccount(Account account) throws AccountAlreadyExistsException{
		
		boolean foundAccount=findAccount(account);
		if(foundAccount)
			throw new AccountAlreadyExistsException();
		
		else {
			accounts[numAccounts]=account;
			numAccounts++;
		}
		
	}
	
	private boolean findAccount(Account account) {
		
		for(int i=0; i<numAccounts; i++) {
			if((accounts[i] instanceof Checking) && (account instanceof Checking))
				return true;
			if((accounts[i] instanceof Savings) && (account instanceof Savings))
				return true;
			if((accounts[i] instanceof CD) && (account instanceof CD))
				return true;
		}
		return false;
	}

	public String getFirstName() {
		return first;
	}
	
	public String getLastName() {
		return last;
	}
	
	public Currency balance(String type) throws AccountDoesNotExistException{
		
		Currency bal;
		
		int indexOfAccount=searchForAccount(type);
		
		if(indexOfAccount==-1)
			throw new AccountDoesNotExistException();
		
		else
			bal=accounts[indexOfAccount].getBalance();
		
		return bal;
	}
	
	public void deposit(Currency money, String type) throws AccountDoesNotExistException, InvalidDepositException{
		
		int indexOfAccount=searchForAccount(type);
		
		if(indexOfAccount==-1)
			throw new AccountDoesNotExistException();
		
		else 
			accounts[indexOfAccount].deposit(money);
		
	}
	
	public void withdraw(Currency money, String type) throws AccountDoesNotExistException, 
		InvalidWithdrawException, InsufficientFundsException{
		
		int indexOfAccount=searchForAccount(type);
		
		if(indexOfAccount==-1)
			throw new AccountDoesNotExistException();
		else if(accounts[indexOfAccount].getBalance().subtract(money).getValue()<0)
			throw new InsufficientFundsException();
		
		else
			accounts[indexOfAccount].withdraw(money);
	}
	
	private int searchForAccount(String type) {
		
		for(int i=0; i<numAccounts; i++) {
			if((accounts[i] instanceof Checking) && type.equals("checking"))
				return i;
			if((accounts[i] instanceof Savings) && type.equals("savings"))
				return i;
			if((accounts[i] instanceof CD) && type.equals("cd"))
				return i;
		}
		return -1;
	}

	public boolean equals(Object obj) {
		
		if(!(obj instanceof Customer))
			return false;
		
		Customer another=(Customer)obj;
		
		return first.equals(another.first) && last.equals(another.last);
	}
}
































