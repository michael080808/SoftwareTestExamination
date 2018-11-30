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
public class DateEqualsTest {
	public Date date = new Date(6, 1, 2001);
	
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { 
				{ new Integer(1), false }, 
				{ new Date(6, 1, 2000), false },
				{ new Date(5, 1, 2001), false },
				{ new Date(6, 2, 2001), false },
				{ new Date(6, 1, 2001), true }});
	}

	@Parameter(0)
	public Object d;
	@Parameter(1)
	public boolean equal;
	
	@Test
	public void test() {
		assertEquals(equal, date.equals(d));
	}
}
