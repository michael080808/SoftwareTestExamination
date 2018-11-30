package net.mooctest;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MonthIllegalTest {
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 1, null }, { 0, new Year(1) },
				{ 13, new Year(1) } });
	}

	@Parameter(0)
	public int month;
	@Parameter(1)
	public Year year;

	@Test(expected = IllegalArgumentException.class)
	public void test() {
		Month m = new Month(month, year);
	}
}
