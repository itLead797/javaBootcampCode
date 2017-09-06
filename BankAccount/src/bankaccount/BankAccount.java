package bankaccount;

public interface BankAccount {
	int getBalance();
	int getAvailBalance();
	boolean deposit(int amount) throws IllegalArgumentException;
	boolean withdrawl(int amount) throws IllegalArgumentException;
}
