package net.mooctest;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class YearIsLeapTest {
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { { 1, false }, { 4, true },
				{ 100, false }, { 400, true }, { -1, true }, { -2, false },
				{ -5, true }, { -101, false }, { -401, true } });
	}

	@Parameter(0)
	public int year;
	@Parameter(1)
	public boolean leap;

	@Test
	public void test() {
		Year y = new Year(year);
		assertEquals(leap, y.isLeap());
	}
}
