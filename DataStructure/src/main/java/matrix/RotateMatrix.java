package matrix;

/**
 * 
 * @author sxu
 *
 * Rotate an N * N matrix clockwise 90 degrees.
 * Assumptions
 *     the matrix is not null and N >= 0.
 *     
 * Examples
 * {{1,2,3},
 *  {8,9,4},
 *  {7,6,5}}
 * after rotation is
 * {{7, 8, 1},
 *  {6, 9, 2},
 *  {5, 4, 3}}
 *
 */


public class RotateMatrix {

	// Method 1: split into levels and for each level split it into four partitions
	// Assumptions: matrix is not null and has size of N * N, N >= 0
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		int round = n / 2;
		for (int level = 0; level < round; level++) {
			int left = level;
			int right = n - 2 - level;
			for (int i = level; i <= right; i++) {
				int tmp = matrix[left][i];
				matrix[left][i] = matrix[n-1-i][left];
				matrix[n-1-i][left] = matrix[n-1-left][n-1-i];
				matrix[n-1-left][n-1-i] = matrix[i][n-1-left];
				matrix[i][n-1-left] = tmp;
			}
		}
	}
	
	
	
	
	public static void main(String[] args) {
		
		int[][] matrix = new int[][] {
			{1,2,3},{8,9,4},{7,6,5}
		};
		rotate(matrix);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	
}







