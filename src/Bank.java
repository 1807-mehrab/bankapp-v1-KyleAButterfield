import java.util.Collections;
import java.util.HashMap;
import java.io.*;
import static java.lang.System.*;



public class Bank implements BankingMadeSimple {
	private HashMap<String, Account> accounts;
	FileWriter fw;
	PrintWriter pw;
	FileReader fr;
	BufferedReader br;
	
	//constructors
	public Bank() {
		accounts = new HashMap<>();
		getActiveAccounts();
	}
	
	public int getNumberOfAccounts() {
		return accounts.size();
		
	}
	
	public Account getSpecificAccount(String key) {
		return accounts.get(key);
	}
	
	@Override
	public void giveMoney(int money) {
		// TODO Auto-generated method stub
		
	}

	public void getActiveAccounts() {
		try {
			FileReader fr = new FileReader("ListOfAccounts.txt");
			BufferedReader br = new BufferedReader(fr);
			
			String buffer;
			String accountNum = "";
			double balance;
			int count = 1;//this will help me know what the parameter grabbed from the file is
			while((buffer = br.readLine()) != null) {
				if(count == 1) {
					accountNum = buffer;
					System.out.println(accountNum);
					count++;
				}else if(count == 2) {
					balance = Double.parseDouble(buffer);
					System.out.println("We are making an account.");
					makeNewAccount(accountNum,balance);
					count = 1;
				}
				
			}
			br.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public double getBalance(Account account) {
		// TODO Auto-generated method stub
		return account.getBalance();
	}

	@Override
	public void makeNewAccount(String accountNumber) {
		// TODO Auto-generated method stub
		Account newAccount = new Account(accountNumber, 0.0);
		accounts.put(accountNumber, newAccount);
		try {
			fw = new FileWriter("ListOfAccouts.txt", true);
			pw = new PrintWriter(fw);
			
			pw.println(accountNumber + "\n");
			pw.println("0.0" + "\n");
			
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
	}


	@Override
	public void makeNewAccount(String accountNumber, double startingBalance) {
		// TODO Auto-generated method stub
		Account newAccount = new Account(accountNumber, startingBalance);
		accounts.put(accountNumber, newAccount);
		try {
			fw = new FileWriter("ListOfAccouts.txt", true);
			pw = new PrintWriter(fw);
			
			pw.println(accountNumber + "\n");
			pw.println(Double.toString(startingBalance) + "\n");
			
			pw.close();
		}catch(IOException e) {
			e.printStackTrace();
			
		}
		
	}
	
}
