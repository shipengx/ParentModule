package com.ti.class10;

import java.util.ArrayList;
import java.util.List;

/*
 * Spiral order traversal I
 * 
 * Traverse an N N 2D array in spiral order clock-wise starting from the top left corner.
 * return the list of traversal sequence.
 * 
 * Assumptions:
 *     The 2D array is not null and has size of N N where N >= 0
 *     
 * Examples:
 * {{1, 2, 3},
 *  {4, 5, 6},
 *  {7, 8, 9}}
 * 
 * The traversal sequence is [1, 2, 3, 6, 9, 8, 7, 4, 5]
 * 
 */

public class SpiralOrderTraversalI {

	public static List<Integer> spiral(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		int n = matrix.length;
		int start = 0;
		int end = n - 1;
		// the base case is when there is 0 or 1 element in the submatrix,
		// A.K.A start < end or start == end
		while (start < end) {
			for (int i = start; i <= end; i++) {
				list.add(matrix[start][i]);
			}
			for (int i = start + 1; i <= end - 1; i++) {
				list.add(matrix[i][end]);
			}
			for (int i = end; i >= start; i--) {
				list.add(matrix[end][i]);
			}
			for (int i = end - 1; i >= start + 1; i--) {
				list.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		// if at last we have 1 element left, we nee to traverse it as well.
		if (start == end) {
			list.add(matrix[start][end]);
		}
		return list;
	}

	
	public static void main(String[] args) {
        int[][] inputArray = new int[][] { {1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiral(inputArray));
        
	}

}
