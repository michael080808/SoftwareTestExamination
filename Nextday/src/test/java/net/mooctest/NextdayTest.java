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
public class NextdayTest {

	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { 
				{ 1, 20, 1, 	1,   1, 21 }, 
				{ 1, 20, 2,  	2,   1, 21 },
				{ 1, 20, 5, 	5,   1, 21 }, 
				{ 1, 20, 101,	101, 1, 21 }, 
				{ 1, 20, 401, 	401, 1, 21 }, 
				{ 1, 20, 4,  	4,   1, 21 },
				{ 1, 20, 100, 	100, 1, 21 }, 
				{ 1, 20, 400, 	400, 1, 21 },
				{ 2, 20, 1, 	1,   2, 21 },
				
				{ 1, 20, -1, 	-1,  1, 21 }, 
				{ 1, 20, -2,  	-2,  1, 21 },
				{ 1, 20, -5, 	-5,  1, 21 }, 
				{ 1, 20, -101,	-101,1, 21 }, 
				{ 1, 20, -401, 	-401,1, 21 },
				
				{ 1,  31, 4,  	4,  2,  1 },
				{ 2,  28, 1, 	1,  3,  1 },
				{ 2,  28, 100, 	100,3,  1 },
				{ 2,  28, 4, 	4,  2, 29 },
				{ 2,  29, 4, 	4,  3,  1 },
				{ 2,  28, 400,	400,2, 29 },
				{ 2,  29, 400, 	400,3,  1 },
				{ 3,  31, 4, 	4,  4,  1 },
				{ 4,  30, 4, 	4,  5,  1 },
				{ 5,  31, 4, 	4,  6,  1 },
				{ 6,  30, 4, 	4,  7,  1 },
				{ 7,  31, 4, 	4,  8,  1 },
				{ 8,  31, 4, 	4,  9,  1 },
				{ 9,  30, 4, 	4, 10,  1 },
				{ 10, 31, 4, 	4, 11,  1 },
				{ 11, 30, 4, 	4, 12,  1 },
				{ 12, 31, 4, 	5,  1,  1 }});
	}

	@Parameter(0)
	public int year;
	@Parameter(1)
	public int month;
	@Parameter(2)
	public int day;
	@Parameter(3)
	public int year_n;
	@Parameter(4)
	public int month_n;
	@Parameter(5)
	public int day_n;
	
	@Test
	public void test() {
		Date n = new Date(year, month, day);
		Date next = Nextday.nextDay(n);
		assertEquals(year_n, next.getYear().getYear());
		assertEquals(month_n, next.getMonth().getMonth());
		assertEquals(day_n, next.getDay().getDay());
	}
}
