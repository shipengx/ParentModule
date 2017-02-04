package com.shipeng.recursion;

public class SumOfAnArray {

	private static int sumOfAnArray(int[] array, int index, int sum) {
		if (array == null || array.length == 0) {
			return -1;
		}
		if (index == array.length) {
			return sum;
		}
		return sumOfAnArray(array, index+1, sum + array[index]);
	}
	
	public static void main(String[] args) {
		
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int result = sumOfAnArray(array, 0, 0);
		System.out.println("the result is: " + result);
		
	}
	
}
