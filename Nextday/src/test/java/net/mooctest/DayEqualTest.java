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
public class DayEqualTest {
	public Day d = new Day(1, new Month(6, new Year(2001)));
	
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { 
				{ new Integer(1), false }, 
				{ new Day(2, new Month(5, new Year(2001))), false },
				{ new Day(1, new Month(6, new Year(2001))), true }});
	}

	@Parameter(0)
	public Object day;
	@Parameter(1)
	public boolean equal;
	
	@Test
	public void test() {
		assertEquals(equal, d.equals(day));
	}
}
