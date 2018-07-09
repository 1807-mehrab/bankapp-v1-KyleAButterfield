import java.util.Scanner;
import java.io.*;

public class Main extends ProgramRunner {
	Bank bank;
	Scanner sc;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main bankApp = new Main();
		bankApp.run();
		
	}

	public Main() {
		bank = new Bank();
		sc = new Scanner(System.in);
	}
	
	

	@Override
	public void run() {
		// TODO run your bank app logic here
		boolean isDone = false;
		String userInput;
		Account user;
		while(isDone == false) {
			System.out.println("Hello welcome to Bank of Kyle.");
			System.out.println("Do you know your account number? Type Y for yes and N for no.");
			//try to take take user input
			 userInput = sc.next();
			 
			if(userInput.equals("Y")) {
				try {
					System.out.println("Please give me your account number?");
					String usersAccount; 
					usersAccount = sc.next();
					user = bank.getSpecificAccount(usersAccount);
					inAccount(user);
				}catch(Exception e) {
					System.out.println("It appears that is not a valid account number.");
					System.out.println("Please check your number and try again.");
				}
			}//end of if Y is typed
			else {
				System.out.println("Do you need to create an acount? Type Y for yes and N for no.");
				userInput = sc.next();
				if(userInput.equals("Y") ) {
				System.out.println("Ok one moment......and how much is your starting deposit?");
				try {
					userInput = sc.next();
					double startingBalance = Double.parseDouble(userInput);
					System.out.println(startingBalance);
					int numberOfAccounts = bank.getNumberOfAccounts();
					if(numberOfAccounts >= 0 && startingBalance != 0 ) {
						String accountNumber = Integer.toString(numberOfAccounts + 1);
						bank.makeNewAccount(accountNumber, startingBalance);
						System.out.println("Your account number is " + accountNumber + ".");
						System.out.println("Please write down your account number so you can retrieve it if you forget your number.");
						System.out.println("If you forget your account number ther is no way to recover it.");
					}else  {
						String accountNumber = Integer.toString(numberOfAccounts + 1);
						bank.makeNewAccount(accountNumber);
						System.out.println("Your starting balance is 0");
						System.out.println("Your account number is " + accountNumber + ".");
						System.out.println("Please write down your account number so you can retrieve it if you forget your number.");
						System.out.println("If you forget your account number ther is no way to recover it.");
					}
				}catch(Exception e) {
					System.out.println("Something went wrong. Please start over and try again");
				}
				}//end of if for creating new account
				
			}//end of else 
			
			
			System.out.println("Are you ready to quit? type Y for yes and N for no");
			userInput = sc.next();
			if(userInput.equals("Y")) {
				System.out.println("Thanks for visiting Bank of Kyle.");
				isDone = true;
			}
		}//end of outer most while
		
	}

	private void inAccount(Account account) {
		boolean isDone = false;
		String userInput;
		while(isDone == false) {
			System.out.println("Welcome to your account your balance is " + account.getBalance());
			System.out.println("Do you want to withdraw funds or deposit funds? Type W for widthraw and D for deposit");
			userInput = sc.next();
			if(userInput.equals("W")) {
				try {
				double balance;
				double withdraw;
				System.out.println("How much would you like to withdraw?");
				withdraw = sc.nextDouble();
				balance = account.getBalance();
				account.setBalance( balance - withdraw);
				}catch(Exception e) {
					System.out.println("Something went wrong. Please start over and try again");
				}
				
		}
		if(userInput.equals("D")) {
			try {
				double balance;
				double deposit;
				System.out.println("How much would you like to deposit?");
				deposit = sc.nextDouble();
				balance = account.getBalance();
				account.setBalance( balance + deposit);
				}catch(Exception e) {
					System.out.println("Something went wrong. Please start over and try again");
				}
			
			System.out.println("If you are done with your account you can type Y for yes or N for n");
			userInput = sc.next();
			if(userInput.equals("Y")) {
				isDone = true;
				}
			}
		
	
		}	
	}
}