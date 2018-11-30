package net.mooctest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class NextdayWithExceptionTest {

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{  1, 20,   0, "Not a valid year" }, 
				{ -1, 20,   0, "Not a valid year" }, 
				
				{ -1, 20,   1, "Not a valid month" },
				{ -1, 20,   4, "Not a valid month" },
				{ -1, 20, 100, "Not a valid month" },
				{ -1, 20, 400, "Not a valid month" },
				{ -1, 20,  20, "Not a valid month" }, 
				{  0, 20,   1, "Not a valid month" }, 
				{ 13,  1,   1, "Not a valid month" }, 
				
				{ 1,  0,    1, "Not a valid day" },
				{ 1, 32,    1, "Not a valid day" } });
	}

	@Parameter(0)
	public int month;
	@Parameter(1)
	public int day;
	@Parameter(2)
	public int year;
	@Parameter(3)
	public String error_msg;

	@Test
	public void test() {
		try {
			Date n = new Date(month, day, year);
			fail("There is no IllegalArgumentException catched.");
		} catch(IllegalArgumentException e) {
			assertEquals(error_msg, e.getMessage());
		} catch(Exception e) {
			fail(e.getMessage());
		}
	}
}
