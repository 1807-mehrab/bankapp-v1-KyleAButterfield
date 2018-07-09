
public interface BankingMadeSimple {
	
	public void makeNewAccount(String accountNumber);
	public void makeNewAccount(String accountNumber, double startingBalance);
	public void giveMoney(int money);
	public double getBalance(Account account);
	
	
	
}
