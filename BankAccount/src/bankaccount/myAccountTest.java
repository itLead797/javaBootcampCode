package bankaccount;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
//import org.junit.Ignore;
import org.junit.Test;

public class myAccountTest {
	static myAccount A1;
	static myAccount A2;
	static myAccount A3;
	static myAccount A4;
	static myAccount A5;
	BankAccount ba;
	BankDB db;
	
	@BeforeClass
	public static void testSetup() {
		System.out.println("starting test");
	}
	
	@AfterClass
	public static void confirmTearDown () {
		assertNull(A1);
		assertNull(A2);
		assertNull(A3);
		assertNull(A4);
		assertNull(A5);
	}
	
	@Before
	public void setUp() throws Exception {
		A1 = new myAccount(1111, true, 1000, 1000, 100, 500);
		A2 = new myAccount(2222, false, 587, 346, 100, 800);
		A3 = new myAccount(3333, true, 897, 239, 1000, 10000);
		A4 = new myAccount(4444, true, 397, 0, 300, 1000);
		A5 = new myAccount(5555, true, 0, 0, 100, 500);
	}
	
	@After
	public void tearDown() {
		A1 = null;
		A2 = null;
		A3 = null;
		A4 = null;
		A5 = null;
	}
	
	
	
	@Test
	public void testMyAccount() {
		//fail();
		myAccount A6 = new myAccount(6666, true, 1000, 800, 100, 500);
		assertNotNull(A6.getAccountNum());
		assertEquals(6666, A6.getAccountNum());
		assertTrue(A6.getStatus());
		assertEquals(1000, A6.getBalance());
		assertEquals(800, A6.getAvailBalance());
		assertEquals(100, A6.getTransactionLimit());
		assertEquals(500, A6.getSessionLimit());
		assertEquals(0, A6.getTotalThisSession());
	}
	
	@Test
	public void testInvalidAccount() {		
		assertNotEquals(6666, A5.getAccountNum());
	}
	
	@Test
	public void testSetStatus() {
		A1.setStatus(true);
		assertTrue(A1.getStatus());
		A2.setStatus(false);
		assertFalse(A2.getStatus());
		
	}
	
	@Test
	public void testGetStatus() {
		assertTrue(A1.getStatus());
		assertFalse(A2.getStatus());

	}
	
	@Test
	public void testSetTransactionLimit() {
		A1.setTransactionLimit(200);
		assertEquals(200, A1.getTransactionLimit());
		A2.setTransactionLimit(200);
		assertEquals(200, A2.getTransactionLimit());
	}
	
	@Test
	public void testGetTransactionLimit() {
		assertEquals(100, A1.getTransactionLimit());
		assertEquals(100, A1.getTransactionLimit());
	}
	
	@Test
	public void testSetSessionLimit() {
		A1.setSessionLimit(200);
		assertEquals(200, A1.getSessionLimit());
		A2.setSessionLimit(200);
		assertEquals(200, A2.getSessionLimit());
	}
	
	@Test
	public void testGetSessionLimit() {
		assertEquals(500, A1.getSessionLimit());
		assertEquals(800, A2.getSessionLimit());
	}
	
	@Test
	public void testGetTotalThisSession() {
		assertEquals(0, A1.getTotalThisSession());
		assertEquals(0, A2.getTotalThisSession());
	}
	
	@Test
	public void testGetBalance() {
		assertEquals(1000, A1.getBalance());
		assertEquals(587, A2.getBalance());
	}
	
	@Test
	public void testGetAvailBalance() {
		assertEquals(1000, A1.getAvailBalance());
		assertEquals(346, A2.getAvailBalance());
	}
	
	@Test
	public void testSetAvailBalance() {
		A1.setAvailBalance(200);
		assertEquals(200, A1.getAvailBalance());
		A2.setAvailBalance(200);
		assertEquals(200, A2.getAvailBalance());
	}
	
	@Test
	public void testSimpleDeposit() {
		int balance = A1.getBalance();
		
		// test single deposit
		boolean returnStatus = false;
		returnStatus = A1.deposit(100);
		assertEquals(100 + balance, A1.getBalance());
		assertEquals(1000, A1.getAvailBalance());
		assertTrue(returnStatus);
		
		// test multiple deposits
		balance = A1.getBalance();

		returnStatus = false;
		returnStatus = A1.deposit(100);		
		assertEquals(100 + balance, A1.getBalance());
		assertEquals(1000, A1.getAvailBalance());
		assertTrue(returnStatus);
	}
	
	@Test
	public void testNoChangeValuesOnDeposit() {
		A1.deposit(100);
		assertEquals(true, A1.getStatus());
		assertEquals(100, A1.getTransactionLimit());
		assertEquals(500, A1.getSessionLimit());
	}
	
	@Test (expected=java.lang.IllegalArgumentException.class)
	public void testNotActiveAccountDeposit() {
		A2.deposit(100);
	}
	
	@Test
	public void testZeroDeposit() {	
		boolean returnStatus = true;
		returnStatus = A1.deposit(0);
		assertFalse(returnStatus);
	}
	
	@Test
	public void testNegativeDeposit() {
		boolean returnStatus = true;
		returnStatus = A1.deposit(-1);
		assertFalse(returnStatus);
	}
	
	@Test
	public void testWithdrawl() {
		int balance = A1.getBalance();
		int availBalance = A1.getAvailBalance();
		int totLimit = A1.getTotalThisSession();
		boolean returnStatus = false;

		// test single withdrawal
		returnStatus = A1.withdrawl(50);
		assertEquals("Balance not reduced by withdrawal amount", balance - 50, A1.getBalance());
		assertEquals("Available balance not reduced by withdrawal amount", availBalance-50, A1.getAvailBalance());
		assertEquals("Total session amount not increased by withdrawal amount", totLimit + 50, A1.getTotalThisSession());
		assertTrue("Withdrawal status returned 'false' value, should be 'true'.", returnStatus);

		// test multiple withdrawal
		balance = A1.getBalance();
		availBalance = A1.getAvailBalance();
		totLimit = A1.getTotalThisSession();
		returnStatus = false;

		returnStatus = A1.withdrawl(50);
		assertEquals("Balance not reduced by withdrawal amount", balance - 50, A1.getBalance());
		assertEquals("Available balance not reduced by withdrawal amount", availBalance-50, A1.getAvailBalance());
		assertEquals("Total session amount not increased by withdrawal amount", totLimit + 50, A1.getTotalThisSession());
		assertTrue("Withdrawal status returned 'false' value, should be 'true'.", returnStatus);
	}
	
	@Test
	public void testNoChangeValuesOnWithdrawal() {
		A1.withdrawl(100);
		assertEquals(true, A1.getStatus());
		assertEquals(100, A1.getTransactionLimit());
		assertEquals(500, A1.getSessionLimit());
	}
	
	@Test (expected=java.lang.IllegalArgumentException.class)
	public void testNotActiveAccountWithdrawl() {		
		A2.withdrawl(100);
	}
	
	@Test
	public void testZeroWithdrawl() {
		boolean returnStatus = true;
		returnStatus = A1.withdrawl(0);
		assertFalse(returnStatus);
	}
	
	@Test
	public void testNegativeWithdrawl() {
		boolean returnStatus = true;
		returnStatus = A1.withdrawl(-1);
		assertFalse(returnStatus);
	}
	
	@Test
	public void testOverTransLimitWithdrawl() {	
		boolean returnStatus = true;
		returnStatus = A1.withdrawl(200); // transaction limit of 100
		assertFalse(returnStatus);
	}
	
	@Test
	public void testOverAvailLimitWithdrawl() {
		boolean returnStatus = true;
		returnStatus = A3.withdrawl(300); // available limit of 239
		assertFalse(returnStatus);
	}
	
	@Test
	public void testOverSessionLimitWithdrawl() {
		boolean returnStatus = false;
		returnStatus = A1.withdrawl(100);
		assertTrue(returnStatus);
		returnStatus = A1.withdrawl(100);
		assertTrue(returnStatus);
		returnStatus = A1.withdrawl(100);
		assertTrue(returnStatus);
		returnStatus = A1.withdrawl(100);
		assertTrue(returnStatus);
		returnStatus = A1.withdrawl(100);
		assertTrue(returnStatus);
		returnStatus = A1.withdrawl(100); // session limit of 500
		assertFalse(returnStatus);
	}
}
