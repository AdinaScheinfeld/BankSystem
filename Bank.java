
import java.util.*;

public class Bank {
	
	private Customer[] bank;
	private int numCustomers;
	private Scanner keyboard;
	
	public Bank() {
		
		bank=new Customer[100];
		numCustomers=0;
		keyboard=new Scanner(System.in);
		
	}
	
	public void printMenu() {

			System.out.println("Please choose an option:\n"
					+ "press N to become a new customer of the bank\n"
					+ "press O to open an account in the bank\n"
					+ "press B to search the balance of a particular account\n"
					+ "press D to deposit money into a particular account\n"
					+ "press W to withdraw money from a particular account\n"
					+ "press Q to exit the program");
	}
	
	public void newCustomer() throws AlreadyCustomerException{
		
		String firstName=getFirstName();
		String lastName=getLastName();
		Customer customer=new Customer(firstName, lastName);
		
		int indexOfAccount=searchForAccount(customer);
		
		if(!(indexOfAccount==-1))
			throw new AlreadyCustomerException();
		else {
			bank[numCustomers]=customer;
			numCustomers++;
			System.out.println("Thank you for becoming a customer of the bank.");
		}
	}
	
	private String getFirstName() {
		System.out.println("Please enter your first name: ");
		String firstName=keyboard.next().toLowerCase();
		return firstName;
	}
	private String getLastName() {
		System.out.println("Please enter your last name: ");
		String lastName=keyboard.next().toLowerCase();
		return lastName;
	}
	private String getAccountType() throws InvalidSelectionException{
				
		System.out.println("Please enter an account type. Your options are Checking, Savings, or CD.");
		String accountType=keyboard.next().toLowerCase();
		
		if(!( (accountType.equals("checking")) || (accountType.equals("savings")) || (accountType.equals("cd")) ))
			throw new InvalidSelectionException();
		

		return accountType;
	}
	private Currency getAmount() {
		
		Currency money;
		
		System.out.println("Please enter an amount of money (in dollars).");
		int amountInput=keyboard.nextInt();
		if(amountInput<0)
			throw new IllegalArgumentException();
		
		int dollarAmount=amountInput*100;
		money=new Currency(dollarAmount);
		
		return money;
	}
	
	private int searchForAccount(Customer customer) {
		
		for(int i=0; i<numCustomers; i++) {
			if(bank[i].equals(customer))
				return i;
		}
		return -1;
	}

	public void openAccount() throws NotACustomerException, InvalidSelectionException,
		AccountAlreadyExistsException{
		
		String firstName=getFirstName();
		String lastName=getLastName();
		Customer customer=new Customer(firstName, lastName);
		Account account=null;

		int indexOfAccount=searchForAccount(customer);
		
		if(indexOfAccount==-1) 
			throw new NotACustomerException();
		
		else {
			
			String accountType=getAccountType();
			
			System.out.println("How much money would you like to deposit initially? Please enter a dollar amount.");
			int initialDeposit=keyboard.nextInt();
			Currency initialCurr=new Currency(initialDeposit*100);
			
			if(accountType.equals("checking"))
				account=new Checking(initialCurr);
			if(accountType.equals("savings"))
				account=new Savings(initialCurr, .10);
			if(accountType.equals("cd"))
				account=new CD(initialCurr, .10);
			
			bank[indexOfAccount].addAccount(account);
			
			System.out.println("Thank you for opening an account in the bank");
		}
	}
	
	public void getBalance() throws NotACustomerException, InvalidSelectionException, 
		AccountDoesNotExistException{
		
		String firstName=getFirstName();
		String lastName=getLastName();
		Customer customer=new Customer(firstName, lastName);
		
		int indexOfAccount=searchForAccount(customer);
		
		if(indexOfAccount==-1)
			throw new NotACustomerException();
		
		else {
			String accountType=getAccountType();
			System.out.println("The balance in your account is "+bank[indexOfAccount].balance(accountType));
		}
		
	}
	
	public void deposit() throws NotACustomerException, InvalidSelectionException,
		AccountDoesNotExistException, InvalidDepositException{
		
		String firstName=getFirstName();
		String lastName=getLastName();
		Customer customer=new Customer(firstName, lastName);
		
		Currency money=getAmount();
		
		int indexOfAccount=searchForAccount(customer);
		
		if(indexOfAccount==-1)
			throw new NotACustomerException();
		
		else {
			String accountType=getAccountType();
			bank[indexOfAccount].deposit(money, accountType);
			
			System.out.println("Your deposit has been successful.");
		}
	}
	
	public void withdraw() throws NotACustomerException, InvalidSelectionException, 
		AccountDoesNotExistException, InsufficientFundsException, InvalidWithdrawException{
		
		String firstName=getFirstName();
		String lastName=getLastName();
		Customer customer=new Customer(firstName, lastName);
		
		Currency money=getAmount();
		
		int indexOfAccount=searchForAccount(customer);
		
		if(indexOfAccount==-1)
			throw new NotACustomerException();
		
		else {
			String accountType=getAccountType();
			bank[indexOfAccount].withdraw(money, accountType);
			System.out.println("Your withdrawal has been successful.");
		}
	}
	
}






















