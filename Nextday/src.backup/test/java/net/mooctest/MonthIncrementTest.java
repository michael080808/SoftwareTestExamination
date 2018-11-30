package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonthIncrementTest {
	public void test_increment_1() {
		Month month = new Month(6, new Year(2001));
		assertTrue(month.increment());
		assertEquals(7, month.getMonth());
	}

	public void test_increment_2() {
		Month month = new Month(12, new Year(2001));
		assertFalse(month.increment());
		assertEquals(13, month.getMonth());
	}
}
