package net.mooctest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DayTest {
	@Test
	public void test_D() {
		Day day = new Day(1, new Month(6, new Year(2001)));
		assertEquals(1, day.getDay());
	}

	public void test_increment_1() {
		Day day = new Day(1, new Month(6, new Year(2001)));
		assertTrue(day.increment());
		assertEquals(2, day.getDay());
	}
	
	public void test_increment_2() {
		Day day = new Day(30, new Month(6, new Year(2001)));
		assertFalse(day.increment());
		assertEquals(31, day.getDay());
	}
}
