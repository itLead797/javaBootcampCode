package bankaccount;

public class myAccount implements BankAccount {

	private int accountNum;
	private boolean status;
	private int balance;
	private int availBalance;
	private int transLimit;
	private int sessionLimit;
	private int totalThisSession;
	
	public myAccount(BankDB db, int account) {
		//BankDB db = new MockDB();
		int[] data = db.getData(account);
		
		this.accountNum = data[0];
		if (data[1] == 0) {
			this.status = true;
		} else {
			this.status = false;
		}
		this.balance = data[2];
		this.availBalance = data[3];
		this.transLimit = data[4];
		this.sessionLimit = data[5];
		this.totalThisSession = 0;
	}
	
	public myAccount(int accountNum, boolean status, int balance, int availBalance, int transLim, int sessionLimit) {
		setAccountNum(accountNum);
		setStatus(status);
		setBalance(balance);
		setAvailbalance(availBalance);
		setTransactionLimit(transLim);
		setSessionLimit(sessionLimit);
		setTotalThisSession(0);
	}

	public int getAccountNum() {
		return this.accountNum;
	}

	public void setAccountNum(int accountNum) {
		this.accountNum = accountNum;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean getStatus() {
		return this.status;
	}

	public void setTransactionLimit(int amount) {
		this.transLimit = amount;
	}

	public int getTransactionLimit() {
		return this.transLimit;
	}

	public void setSessionLimit(int amount) {
		this.sessionLimit = amount;
	}

	public int getSessionLimit() {
		return this.sessionLimit;
	}

	private void setTotalThisSession(int amount) {		
		this.totalThisSession+= amount;
	}
	
	public int getTotalThisSession() {
		return this.totalThisSession;
	}

	private void setBalance(int amount) {	
		this.balance = amount;
	}
	
	@Override
	public int getBalance() {
		return this.balance;
	}

	private void setAvailbalance(int amount) {	
		this.availBalance = amount;
	}
	
	@Override
	public int getAvailBalance() {
		return this.availBalance;
	}

	
	public void setAvailBalance(int amount) {
		this.availBalance = amount;
	}
	
	@Override
	public boolean deposit(int amount) throws IllegalArgumentException {
		boolean depositStatus = false;		
		
		if (this.status == false) {
			throw new IllegalArgumentException();
		} 
		if(amount > 0) {
			this.balance+=amount;
			depositStatus = true;
		}
	return depositStatus;
	}

	@Override
	public boolean withdrawl(int amount) throws IllegalArgumentException {
		boolean withdrawlStatus = false;		
		
		if (this.status == false) {
				throw new IllegalArgumentException();
			} 
		if (amount > 0 &&
			amount <= this.transLimit &&
			amount + this.totalThisSession  <= this.sessionLimit &&
			amount <= this.availBalance &&
			amount <= this.balance) 
		{
			this.balance-=amount;
			this.availBalance-=amount;
			this.totalThisSession+=amount;
			withdrawlStatus = true;
		}
		return withdrawlStatus;
	}

	

}
