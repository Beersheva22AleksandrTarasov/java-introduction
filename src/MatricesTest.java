import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class MatricesTest {
	@Test
	void transpTest() {
		int[][] matrix = {
						 {1, 2},
						 {3, 4},
						 {4, 5}
						 };
		int expected[][] = {
						   {1, 3, 4},
						   {2, 4, 5}
						   };
		
		int[][] matrix1 = {
						  {1, 2, 3, 4},
						  {5, 6, 7, 8},
						  {0, 0, 0, 0},
						  {1, 1, 1, 1}
						  };
		int expected1[][] = {
							{1, 5, 0, 1},
							{2, 6, 0, 1},
							{3, 7, 0, 1},
							{4, 8, 0, 1}
							};
		assertArrayEquals(expected, Matrices.transp(matrix));
		assertArrayEquals(expected1, Matrices.transp(matrix1));
	}
}
