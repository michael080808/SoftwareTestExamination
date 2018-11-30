package net.mooctest;

import static org.junit.Assert.*;

import org.junit.Test;

import java.lang.reflect.*;

public class CalendarUnitTest {
	@Test
	public void test() {
		Year y = new Year(2001);
		
		try {
			Method method_set = CalendarUnit.class.getDeclaredMethod("setCurrentPos", new Class[] {int.class});
			Method method_get = CalendarUnit.class.getDeclaredMethod("getCurrentPos", new Class[] {});
			method_set.setAccessible(true);
			method_set.invoke(y, new Object[] {2002});
			method_set.setAccessible(false);
			
			method_get.setAccessible(true);
			Object o = method_get.invoke(y, new Object[] {});
			method_get.setAccessible(false);
			
			System.out.println((int) o);
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}
}
