package wordcount;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CounterTest {
	Counter c;
	
	@Before
	public void setUp() throws Exception {
		c = new CounterImp();
	}
	
	@Test
	public void testTrue() {
		assertTrue(c.blankCount("Hi There"));
	}
	
	@Test
	public void testFalse() {
		assertFalse(c.blankCount("HiThere"));
	}
	
	@Test (expected=java.lang.IllegalArgumentException.class)
	public void testEmptyString() {
		c.blankCount("");
	}
	
	@Test (expected=java.lang.IllegalArgumentException.class)
	public void testNull() {
		c.blankCount(null);
	}
	
//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
}
