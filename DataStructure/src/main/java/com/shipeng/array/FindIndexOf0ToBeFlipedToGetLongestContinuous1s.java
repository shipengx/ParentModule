package com.shipeng.array;

/**
 * Find index of 0 to be replaced with 1 to get longest continuous sequence of
 * 1s in a binary array.
 * 
 * Given an array of 0s and 1s, find the position of 0 to be replaced with 1 to
 * get longest continuous sequence of 1s. Expected time complexity is O(n) and
 * auxiliary sapce is O(1).
 * 
 * Example: input: arr[] = {1,1,0,0,1,0,1,1,1,0,1,1,1} output: index = 9
 * Assuming array index starts from 0, replacing 0 with 1 at index 9 causes the
 * maximum continue sequence of 1s.
 * 
 * Input: arr[] = {1,1,1,1,0} Output: index 4
 *
 */

public class FindIndexOf0ToBeFlipedToGetLongestContinuous1s {

	private static int simpleSolution(int[] array) {
		if (array == null || array.length == 0) {
	        return -1;
	    }	
	    int[] m1 = new int[array.length];
	    int[] m2 = new int[array.length];

	    int leftCount = 0;
	    for (int i = 0; i < array.length; i++) {
	        if (array[i] == 0) {
		    m1[i] = leftCount;
	            leftCount = 0;
	        }else {
	           m1[i] = leftCount;
	           leftCount++;
	        }
	    }
	 
	    int rightCount = 0;
	    for (int i = array.length-1; i >= 0; i--) {
	    	if (array[i] == 0) {
	            m2[i] = rightCount;
	            rightCount = 0;
	        }else {
	            m2[i] = rightCount;
	            rightCount++;
	        }
	    }
	     int max = 0;
	     int resultIndex = -1;
	     for (int i = 0; i < array.length; i++) {
	           int sum = m1[i] + m2[i];
	           System.out.println("sum is: " + sum + ", index is: " + i + ", value is: " + array[i] + ", left sum is: " + m1[i] + ", right sum is: " + m2[i]);
	           if (sum > max && array[i] == 0) {
		           max = sum;
	               resultIndex = i;
	           }
	     }
		
	     return resultIndex;

	}
	
	private static int betterSolution(int[] array) {
		int max = 0;
		int resultIndex = 0;
		
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] == 0) {
				
			}else {
				
			}
		}
		return resultIndex;
	}
	

	public static void main(String[] args) {
		int[] inputArray1 = new int[] {1,1,1,1,0};
		int resultIndex = simpleSolution(inputArray1);
		System.out.println("result index is: " + resultIndex);
		
		int[] inputArray2 = new int[] {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
		int resultIndex2 = simpleSolution(inputArray2);
		System.out.println("result index is: " + resultIndex2);
		
		
	}

}
