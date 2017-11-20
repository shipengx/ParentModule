package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sxu
 *
 *         Spiral order traverse I
 * 
 *         Traverse an N * N 2D array in spiral order clock-wise starting from
 *         the top left corner. Return the list of traversal sequence.
 * 
 *         Assumptions The 2D array is not null and has size of N * N where N >=
 *         0
 * 
 *         Examples {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}
 * 
 *         the traversal sequence is [1,2,3,6,9,8,7,4,5]
 *
 */

public class SpiralOrderTraversalI {

	public List<Integer> spiral(int[][] matrix) {
		// method 1: recurse traversal
		// Assumptions: matrix is N * N, N >= 0, matrix is not null
		List<Integer> list = new ArrayList<Integer>();
		recursiveTraverse(matrix, 0, matrix.length, list);
		return list;
	}

	private void recursiveTraverse(int[][] matrix, int offset, int size, List<Integer> result) {
		// base case is when there is only 0 or 1 element left.
		if (size == 0) {
			return;
		}

		// do not forget this base case.
		if (size == 1) {
			result.add(matrix[offset][offset]);
			return;
		}

		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset][offset + i]);
		}

		for (int i = 0; i < size - 1; i++) {
			result.add(matrix[offset + i][offset + size - 1]);
		}

		for (int i = size - 1; i >= 1; i--) {
			result.add(matrix[offset + size - 1][offset + i]);
		}

		for (int i = size - 1; i >= 1; i--) {
			result.add(matrix[offset + i][offset]);
		}

		recursiveTraverse(matrix, offset + 1, size - 2, result);
	}

}
