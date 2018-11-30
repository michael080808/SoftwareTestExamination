package net.mooctest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SudokuPuzzleTest {
	List c = Arrays.asList(new Object[][]{
			{0, 1, "9", false},
			{0, 3, "3", false},
			{0, 6, "5", false},
			{0, 8, "4", false},
			
			{1, 3, "4", false},
			{1, 5, "6", false},
			
			{2, 4, "8", false},
			{2, 8, "3", false},
			
			{3, 0, "2", false},
			{3, 5, "8", false},
			{3, 7, "7", false},
			
			{4, 0, "8", false},
			{4, 2, "5", false},
			{4, 6, "3", false},
			{4, 8, "1", false},
			
			{5, 1, "1", false},
			{5, 3, "5", false},
			{5, 8, "9", false},
			
			{6, 0, "5", false},
			{6, 4, "6", false},
			
			{7, 3, "2", false},
			{7, 5, "5", false},
			
			{8, 0, "6", false},
			{8, 2, "7", false},
			{8, 5, "4", false},
			{8, 7, "5", false}
	});
	
	List success = Arrays.asList(new Object[][] {
		{0, 0, "5", false}, 
		{0, 1, "3", false}, 
		{0, 2, "4", true}, 
		{0, 3, "6", true}, 
		{0, 4, "7", false}, 
		{0, 5, "8", true}, 
		{0, 6, "9", true}, 
		{0, 7, "1", true}, 
		{0, 8, "2", true}, 
		{1, 0, "6", false}, 
		{1, 1, "7", true}, 
		{1, 2, "2", true}, 
		{1, 3, "1", false}, 
		{1, 4, "9", false}, 
		{1, 5, "5", false}, 
		{1, 6, "3", true}, 
		{1, 7, "4", true}, 
		{1, 8, "8", true}, 
		{2, 0, "1", true}, 
		{2, 1, "9", false}, 
		{2, 2, "8", false}, 
		{2, 3, "3", true}, 
		{2, 4, "4", true}, 
		{2, 5, "2", true}, 
		{2, 6, "5", true}, 
		{2, 7, "6", false}, 
		{2, 8, "7", true}, 
		{3, 0, "8", false}, 
		{3, 1, "5", true}, 
		{3, 2, "9", true}, 
		{3, 3, "7", true}, 
		{3, 4, "6", false}, 
		{3, 5, "1", true}, 
		{3, 6, "4", true}, 
		{3, 7, "2", true}, 
		{3, 8, "3", false}, 
		{4, 0, "4", false}, 
		{4, 1, "2", true}, 
		{4, 2, "6", true}, 
		{4, 3, "8", false}, 
		{4, 4, "5", true}, 
		{4, 5, "3", false}, 
		{4, 6, "7", true}, 
		{4, 7, "9", true}, 
		{4, 8, "1", false}, 
		{5, 0, "7", false}, 
		{5, 1, "1", true}, 
		{5, 2, "3", true}, 
		{5, 3, "9", true}, 
		{5, 4, "2", false}, 
		{5, 5, "4", true}, 
		{5, 6, "8", true}, 
		{5, 7, "5", true}, 
		{5, 8, "6", false}, 
		{6, 0, "9", true}, 
		{6, 1, "6", false}, 
		{6, 2, "1", true}, 
		{6, 3, "5", true}, 
		{6, 4, "3", true}, 
		{6, 5, "7", true}, 
		{6, 6, "2", false}, 
		{6, 7, "8", false}, 
		{6, 8, "4", true}, 
		{7, 0, "2", true}, 
		{7, 1, "8", true}, 
		{7, 2, "7", true}, 
		{7, 3, "4", false}, 
		{7, 4, "1", false}, 
		{7, 5, "9", false}, 
		{7, 6, "6", true}, 
		{7, 7, "3", true}, 
		{7, 8, "5", false}, 
		{8, 0, "3", true}, 
		{8, 1, "4", true}, 
		{8, 2, "5", true}, 
		{8, 3, "2", true}, 
		{8, 4, "8", false}, 
		{8, 5, "6", true}, 
		{8, 6, "1", true}, 
		{8, 7, "7", false}, 
		{8, 8, "9", false}
	});
	
	@Test
	public void test_S1() {
		SudokuPuzzleType type = SudokuPuzzleType.NINEBYNINE;
		SudokuPuzzle puzzle = new SudokuPuzzle(type.getRows(),
				type.getColumns(), type.getBoxWidth(), type.getBoxHeight(),
				type.getValidValues());
		assertEquals(type.getRows(), puzzle.getNumRows());
		assertEquals(type.getColumns(), puzzle.getNumColumns());
		assertEquals(type.getBoxWidth(), puzzle.getBoxWidth());
		assertEquals(type.getBoxHeight(), puzzle.getBoxHeight());
		assertArrayEquals(type.getValidValues(), puzzle.getValidValues());

		for (int i = 0; i < puzzle.getNumRows(); i++)
			for (int j = 0; j < puzzle.getNumColumns(); j++) {
				assertEquals("", puzzle.getValue(i, j));
				assertTrue(puzzle.isSlotMutable(i, j));
			}
		
		SudokuPuzzle puzzle_clone = new SudokuPuzzle(puzzle);
		assertEquals(type.getRows(), puzzle_clone.getNumRows());
		assertEquals(type.getColumns(), puzzle_clone.getNumColumns());
		assertEquals(type.getBoxWidth(), puzzle_clone.getBoxWidth());
		assertEquals(type.getBoxHeight(), puzzle_clone.getBoxHeight());
		assertArrayEquals(type.getValidValues(), puzzle_clone.getValidValues());

		for (int i = 0; i < puzzle_clone.getNumRows(); i++)
			for (int j = 0; j < puzzle_clone.getNumColumns(); j++) {
				assertEquals("", puzzle.getValue(i, j));
				assertTrue(puzzle.isSlotMutable(i, j));
			}
		
		System.out.println(puzzle.toString());
	}
	
	@Test
	public void test_S2() {
		SudokuPuzzleType type = SudokuPuzzleType.NINEBYNINE;
		SudokuPuzzle puzzle = new SudokuPuzzle(type.getRows(), type.getColumns(), type.getBoxWidth(), type.getBoxHeight(), type.getValidValues());
		for(Object o: c) {
			Object[] item = (Object[]) o;
			puzzle.makeMove((int) item[0], (int) item[1], (String) item[2], (boolean) item[3]);
		}
		
		puzzle.makeMove(0, 0, "A", true);
		assertEquals(true, puzzle.isSlotMutable(0, 0));
		assertEquals("", puzzle.getValue(0, 0));
		
		puzzle.makeMove(0, 0, "9", true);
		assertEquals(true, puzzle.isSlotMutable(0, 0));
		assertEquals("", puzzle.getValue(0, 0));
		
		puzzle.makeMove(0, 0, "2", true);
		assertEquals(true, puzzle.isSlotMutable(0, 0));
		assertEquals("", puzzle.getValue(0, 0));
		
		puzzle.makeMove(1, 0, "9", true);
		assertEquals(true, puzzle.isSlotMutable(1, 0));
		assertEquals("", puzzle.getValue(1, 0));

		puzzle.makeMove(0, 1, "2", true);
		assertEquals(false, puzzle.isSlotMutable(0, 1));
		assertEquals("9", puzzle.getValue(0, 1));

		try {
			puzzle.makeMove(9, 9, "1", true);
		} catch (ArrayIndexOutOfBoundsException e) {
			assertEquals("java.lang.ArrayIndexOutOfBoundsException", e.getClass().getName());
		} catch (Exception e) {
			fail(e.getMessage());
		}
		
		System.out.println(puzzle);
		
		puzzle.makeMove(0, 0, "1", true);
		assertEquals(true, puzzle.isSlotMutable(0, 0));
		assertEquals("1", puzzle.getValue(0, 0));
		
		System.out.println(puzzle);
		
		puzzle.makeSlotEmpty(0, 0);
		assertEquals(true, puzzle.isSlotMutable(0, 0));
		assertEquals("", puzzle.getValue(0, 0));
		
		System.out.println(puzzle);
	}

	@Test
	public void test_S3() {
		SudokuPuzzleType type = SudokuPuzzleType.NINEBYNINE;
		SudokuPuzzle puzzle = new SudokuPuzzle(type.getRows(), type.getColumns(), type.getBoxWidth(), type.getBoxHeight(), type.getValidValues());
		for(Object o: c) {
			Object[] item = (Object[]) o;
			puzzle.makeMove((int) item[0], (int) item[1], (String) item[2], (boolean) item[3]);
		}
		
		puzzle.makeMove(0, 0, "1", false);
		puzzle.makeSlotEmpty(0, 0);
		
		assertFalse(puzzle.isSlotAvailable(9, 0));
		assertFalse(puzzle.isSlotAvailable(0, 9));
		assertFalse(puzzle.isSlotAvailable(-1, 0));
		assertFalse(puzzle.isSlotAvailable(0, -1));
		
		assertFalse(puzzle.isSlotAvailable(0, 1));
		assertFalse(puzzle.isSlotAvailable(0, 0));
		
		assertTrue(puzzle.isSlotAvailable(1, 0));
	}
	
	@Test
	public void test_S4() {
		SudokuPuzzleType type = SudokuPuzzleType.NINEBYNINE;
		SudokuPuzzle puzzle = new SudokuPuzzle(type.getRows(), type.getColumns(), type.getBoxWidth(), type.getBoxHeight(), type.getValidValues());
		for(Object o: c) {
			Object[] item = (Object[]) o;
			puzzle.makeMove((int) item[0], (int) item[1], (String) item[2], (boolean) item[3]);
		}
		
		String[][] str = puzzle.getBoard();
		for(int i = 0; i < str.length; i++) {
			for(int j = 0; j < str[i].length; j++) {
				System.out.print((str[i][j].equals("") ? " " : str[i][j]) + " ");
			}
			System.out.println();
		}
	}

	@Test
	public void test_S5() {
		SudokuPuzzleType type = SudokuPuzzleType.NINEBYNINE;
		SudokuPuzzle puzzle = new SudokuPuzzle(type.getRows(), type.getColumns(), type.getBoxWidth(), type.getBoxHeight(), type.getValidValues());
		
		assertFalse(puzzle.boardFull());
		
		for(Object o: success) {
			Object[] item = (Object[]) o;
			puzzle.makeMove((int) item[0], (int) item[1], (String) item[2], (boolean) item[3]);
		}
		
		assertTrue(puzzle.boardFull());
	}
}
