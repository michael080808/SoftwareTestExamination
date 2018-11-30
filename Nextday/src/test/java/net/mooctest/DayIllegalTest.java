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
public class DayIllegalTest {
	static Month illegal = new Month(12, new Year(2001));
	
	static {
		assertFalse(illegal.increment());
	}
	
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 1, null },
				{ 1, illegal },
				{ 0, new Month(6, new Year(2001)) },
				{ 31, new Month(6, new Year(2001)) } });
	}

	@Parameter(0)
	public int day;
	@Parameter(1)
	public Month month;

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		Day m = new Day(day, month);
	}
}
