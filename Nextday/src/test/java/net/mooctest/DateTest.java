package net.mooctest;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DateTest {
	@Test
	public void test_D1() {
		Date date = new Date(6, 1, 2001);
		date.printDate();
	}
	
	@Test
	public void test_D2() {
		Date date = new Date(6, 1, 2001);
		assertEquals("6/1/2001", date.toString());
	}
}
