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
public class SudokuPuzzleTypeTest {
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] {
				{ 
					SudokuPuzzleType.SIXBYSIX, 
					6, 
					6, 
					3, 
					2,
					new String[] { "1", "2", "3", "4", "5", "6" },
					"6 By 6 Game"
				},
				{
					SudokuPuzzleType.NINEBYNINE,
					9,
					9,
					3,
					3,
					new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9" }, 
					"9 By 9 Game"
				},
				{
					SudokuPuzzleType.TWELVEBYTWELVE,
					12,
					12,
					4,
					3,
					new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C" }, 
					"12 By 12 Game" 
				},
				{
					SudokuPuzzleType.SIXTEENBYSIXTEEN,
					16,
					16,
					4,
					4,
					new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G" },
					"16 By 16 Game" } 
				});
	}

	@Parameter(0)
	public SudokuPuzzleType type;
	@Parameter(1)
	public int rows;
	@Parameter(2)
	public int columns;
	@Parameter(3)
	public int boxWidth;
	@Parameter(4)
	public int boxHeight;
	@Parameter(5)
	public String [] validValues;
	@Parameter(6)
	public String desc;
	
	@Test
	public void test() {
		SudokuPuzzleType t = type;
		assertEquals(rows, t.getRows());
		assertEquals(columns, t.getColumns());
		assertEquals(boxWidth, t.getBoxWidth());
		assertEquals(boxHeight, t.getBoxHeight());
		assertArrayEquals(validValues, t.getValidValues());
		assertEquals(desc, t.toString());
	}
}
