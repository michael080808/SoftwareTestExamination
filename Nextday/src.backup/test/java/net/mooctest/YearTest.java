package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class YearTest {
	@Test
	public void testYearY1() {
		Year y = new Year(1);
		assertEquals(1, y.getYear());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testYearY2() {
		Year y = new Year(0);
	}
	
	@Test
	public void testYearY3() {
		Year y1 = new Year(2000);
		Integer y2 = new Integer(1998);
		assertFalse(y1.equals(y2));
	}
	
	@Test
	public void testYearY4() {
		Year y1 = new Year(2000);
		Year y2 = new Year(2000);
		assertTrue(y1.equals(y2));
	}
	
	@Test
	public void testYearY5() {
		Year y1 = new Year(2000);
		Year y2 = new Year(1998);
		assertFalse(y1.equals(y2));
	}
	
	@Test
	public void testYearY6() {
		Year y = new Year(2000);
		assertTrue(y.increment());
		assertEquals(2001, y.getYear());
	}
	
	@Test
	public void testYearY7() {
		Year y = new Year(-1);
		assertTrue(y.increment());
		assertEquals(1, y.getYear());
	}
}
