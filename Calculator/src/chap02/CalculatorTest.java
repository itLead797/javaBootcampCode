package chap02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CalculatorTest {

	@Test
	public void testDiv001() {
		Calculator c = new CalculatorImp();
		assertEquals(10, c.div(10,1));
	}
	
	@Test(expected=java.lang.ArithmeticException.class)
    public void testDivideByZero() {
		Calculator c = new CalculatorImp();		
		assertEquals(java.lang.ArithmeticException.class, c.div(10,0));
    }
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//Calculator c = new CalculatorImp();
	}

	@After
	public void tearDown() throws Exception {
	}
}
