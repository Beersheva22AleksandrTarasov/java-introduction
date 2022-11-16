
public class Matrices {

	public static int[][] createRandomMatrix(int rows, int columns, int minValue, int maxValue) {
		int res[][] = new int[rows][columns];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				res[i][j] = (int) Numbers.getRandomNumber(minValue, maxValue);
				System.out.print(res[i][j] + "\t");
			}
			System.out.println();
		}
		return res;
	}

	
	public static int[][] transp(int[][] matrix) {
		int transMat[][] = new int[matrix[0].length][matrix.length];
		transpMatrix(transMat, matrix);

		return transMat;
	}

	public static int[][] transpMatrix(int[][] mat, int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				mat[j][i] = matrix[i][j];
			}
		}
		return mat;
	}
}
