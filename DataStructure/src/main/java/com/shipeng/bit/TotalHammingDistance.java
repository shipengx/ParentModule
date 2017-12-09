package com.shipeng.bit;

/*
 * Total Hamming distance
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total hamming distance between all pairs of the given numbers.
 * 
 * Example:
 * Input: 4, 14, 2
 * Output: 6
 * 
 * Explanation:
 * In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just showing the four bits relevant in this case).
 * So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * 
 * Note:
 *     1. Elements of the given array are in the range of 0 to 10 ^ 9
 *     2. Length of the array will not exceed 10 ^ 4
 * 
 */

public class TotalHammingDistance {

	public int totalHammingDistance(int[] nums) {
		int result = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			int oneCount = 0;
			for (int j = 0; j < nums.length; j++) {
				if ((nums[j] & mask) != 0) {
					oneCount++;
				}
			}
			// for current bit position, the total = oneCount * zeroCount,
			// because for each one in oneCount, there're zeroCount zeroes for the one.
			result += (oneCount * (nums.length - oneCount));
			mask = mask << 1;
		}
		return result;
	}

}
