package com.shipeng.DP;

/*
 * Largest sum of a subarray
 * Given an unsorted array, find the (contiguous) subarray that has the greatest sum.
 * Return the sum.
 * 
 * For example, if the input array is {1,2,4,-1,-20,10,-1}, the greatest sum is achieved by
 * subarray { 1,2,4,-1,-2,10}
 * 
 * Solution:
 * M[i] represents the greatest sum from left-hand side to the input[i] elements, (including the i-th element)
 * M[i] = M[i-1] + input[i]      if (M[i-1] >= 0) 
 *        input[i]               otherwise;
 *       
 * index   0   1   2   3   4   5   6
 * input { 1,  2,  4, -1,  -2, 10, -1}
 * 
 * M[i] =  1   3   7   6   4  14   13
 * int global_max = 14
 * 
 */

public class LargestSumOfASubarray {
	
	
	
	
}
