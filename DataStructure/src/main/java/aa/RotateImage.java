package aa;

/*
 * Rotate Image
 * 
 * You are given an n x n 2D matrix representing an image.
 * Rotate the image by 90 degrees (clockwise).
 * 
 * Follow up:
 * Could you do this in-place ?
 * 
 */

public class RotateImage {

	public void rotate(int[][] matrix) {
		int n = matrix.length;

		for (int i = 0; i < n / 2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.0); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n - j - 1][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
				matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
				matrix[j][n - 1 - i] = temp;
			}
		}
	}

	public void rotate1(int[][] matrix) {
		int n = matrix.length;
		if (n <= 1) {
			return;
		}
		int round = n / 2;
		for (int level = 0; level < round; level++) {
			int left = level;
			int right = n - 2 - level;

			for (int i = left; i <= right; i++) {
				int tmp = matrix[left][i];
				matrix[left][i] = matrix[n - 1 - i][left];
				matrix[n - 1 - i][left] = matrix[n - 1 - left][n - 1 - i];
				matrix[n - 1 - left][n - 1 - i] = matrix[i][n - 1 - left];
				matrix[i][n - 1 - left] = tmp;
			}

		}
	}

}
