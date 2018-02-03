package com.ti.class10;

import java.util.ArrayList;
import java.util.List;

/*
 * Spiral Order Traversal II
 * 
 * Traverse an M N 2D array in spiral order clock-wise starting from the top left corner.
 * Return the list of traversal sequence.
 * 
 * Assumptions:
 *     The 2D array is not null and has size of M N where M, N >= 0
 * 
 * Examples
 * { { 1, 2, 3, 4},
 *   { 5, 6, 7, 8},
 *   { 9, 10, 11, 12}}
 * 
 * The traversal sequence is [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7]
 * 
 */

public class SpiralOrderTraversalII {

	public List<Integer> spiral(int[][] matrix) {
		// Assumptions: matrix is not null, has size of M * N, where M, N >= 0
		List<Integer> list = new ArrayList<Integer>();
		int m = matrix.length;
		// need to handle this case since if m == 0, matrix[0].length will
		// throw ArrayIndexOutOfBoundException.
		if (m == 0) {
			return list;
		}
		int n = matrix[0].length;
		int left = 0;
		int right = n - 1;
		int up = 0;
		int down = m - 1;
		// the base case is a little complicated comparing to N * N matrix.
		// 1. there is nothing left.
		// 2. there is one row left.
		// 3. there is one column left.
		while (left < right && up < down) {
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
			for (int i = up + 1; i <= down - 1; i++) {
				list.add(matrix[i][right]);
			}
			for (int i = right; i >= left; i--) {
				list.add(matrix[down][i]);
			}
			for (int i = down - 1; i >= up + 1; i--) {
				list.add(matrix[i][left]);
			}
			left++;
			right--;
			up++;
			down--;
		}
		// 1. if there is nothing left.
		if (left > right || up > down) {
			return list;
		}
		// 2. if there is one column left.
		if (left == right) {
			for (int i = up; i <= down; i++) {
				list.add(matrix[i][left]);
			}
		} else {
			// 3. if there is one row left.
			for (int i = left; i <= right; i++) {
				list.add(matrix[up][i]);
			}
		}
		return list;
	}

}
