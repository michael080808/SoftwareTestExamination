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
public class SudokuGeneratorTest {
	@Parameters
	public static Collection data() {
		return Arrays.asList(new Object[][] { 
				{ SudokuPuzzleType.SIXBYSIX, 1 }, 
				{ SudokuPuzzleType.NINEBYNINE, 1 },
				{ SudokuPuzzleType.TWELVEBYTWELVE, 1 },
				{ SudokuPuzzleType.SIXTEENBYSIXTEEN, 1 } });
	}

	public SudokuGenerator generator = new SudokuGenerator();
	@Parameter(0)
	public SudokuPuzzleType type;
	@Parameter(1)
	public int total_samples;

	@Test
	public void test() {
		for(int i = 0; i < total_samples; i++) {
			SudokuPuzzle puzzle = generator.generateRandomSudoku(type);
			System.out.print(puzzle);
		}
	}
}
