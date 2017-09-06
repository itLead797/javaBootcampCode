package bankaccount;

public interface BankDB {
	public int[] getData(int account);
	public void putData(int account, int[] data);
}
