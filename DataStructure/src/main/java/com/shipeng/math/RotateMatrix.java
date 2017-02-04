package com.shipeng.math;

public class RotateMatrix {
	
	public static void rotate(int[][] matrix) {
		int n = matrix.length;
		for (int i = 0; i < n /2; i++) {
			for (int j = 0; j < Math.ceil(((double) n) / 2.); j++) {
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-1-j][i];
				matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
				matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
				matrix[j][n-1-i] = temp;
			}
		}
	}
	
	public static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] matrix = new int[][] { {1, 2, 3}, {4,5,6}, {7,8,9}};
		rotate(matrix);
		printMatrix(matrix);
	}
}
