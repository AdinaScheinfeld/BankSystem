import java.util.*;

public class ProgramHW3 {
	
	public static void main(String[] args) {
		
		Scanner keyboard=new Scanner(System.in);
		
		boolean notDone=true;
		
		Bank bank=new Bank();
		char selection;

		try {
			do {
				bank.printMenu();
				selection=keyboard.next().toUpperCase().charAt(0);
				
				switch(selection) {
				case 'N':
					bank.newCustomer();
					break;
				case 'O':
					bank.openAccount();
					break;
				case 'B':
					bank.getBalance();
					break;
				case 'D':
					bank.deposit();
					break;
				case 'W':
					bank.withdraw();
					break;
				case 'Q':
					System.out.println("Thank you for using this bank!");
					notDone=false;
					break;
				default:
					System.out.println("Please enter a valid selection.");
				}
			}while(notDone);
		}catch(AccountAlreadyExistsException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(AccountDoesNotExistException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(AlreadyCustomerException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(InsufficientFundsException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(InvalidDepositException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(InvalidSelectionException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(InvalidWithdrawException e) {
			System.err.println("Error-"+e.getMessage());
		}catch(NotACustomerException e) {
			System.err.println("Error-"+e.getMessage());
		}
		
		keyboard.close();

	}

}
