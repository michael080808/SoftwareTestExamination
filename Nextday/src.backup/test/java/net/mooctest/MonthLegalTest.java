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
public class MonthLegalTest {
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { 
				{ 1, new Year(1), 31 }, 
				{ 2, new Year(1), 28 },
				{ 2, new Year(4), 29 },
				{ 3, new Year(1), 31 },
				{ 4, new Year(1), 30 }, 
				{ 5, new Year(1), 31 },
				{ 6, new Year(1), 30 },
				{ 7, new Year(1), 31 }, 
				{ 8, new Year(1), 31 },
				{ 9, new Year(1), 30 },
				{ 10, new Year(1), 31 }, 
				{ 11, new Year(1), 30 },
				{ 12, new Year(1), 31 }});
	}

	@Parameter(0)
	public int month;
	@Parameter(1)
	public Year year;
	@Parameter(2)
	public int range;
	
	@Test
	public void test() {
		Month m = new Month(month, year);
		assertEquals(range, m.getMonthSize());
	}
}
