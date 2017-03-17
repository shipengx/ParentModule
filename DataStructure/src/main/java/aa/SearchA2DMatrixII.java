package aa;

/*
 * Search a 2D matrix II
 * 
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 *     Integers in each row are sorted in ascending from left to right.
 *     Integers in each column are sorted in ascending from top to bottom.
 *    
 * For example,
 * Consider following matrix:
 * 
 * [
 *    [1, 4, 7, 11, 15],
 *    [2, 5, 8, 12, 19],
 *    [3, 6, 9, 16, 22],
 *    [10, 13, 14, 17, 24],
 *    [18, 21, 23, 26, 30]
 * ]
 * 
 * Given target = 5, return true.
 * Given target = 20, return false.
 * 
 */

public class SearchA2DMatrixII {

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length < 0) {
			return false;
		}
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;

		int i = m;
		int j = 0;

		while (i >= 0 && j <= n) {
			if (target < matrix[i][j]) {
				i--;
			} else if (target > matrix[i][j]) {
				j++;
			} else {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Search start point can either be (0,m) to (n,0) or (n,0) to (0,m),
	 * because we can eliminate either one row or one column
	 * 
	 * However, if we search from (0,0), there are two directions that has number larger than current number.
	 * 
	 * Time complexity: O(m+n) and O(1) space.
	 * 
	 */
	
}
