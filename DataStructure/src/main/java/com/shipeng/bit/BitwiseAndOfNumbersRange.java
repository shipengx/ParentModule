package com.shipeng.bit;

/*
 * Binary Number with Alternating bits
 * 
 * Given a positive number, check whether it has alternating bits:
 * namely, if two adjacent bits will always have different values.
 * 
 * Example 1:
 * Input : 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * 
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * 
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * 
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 * 
 */

public class BitwiseAndOfNumbersRange {

	// method 2: from observation, we can tell that we only need to find out the
	// "left equal part" of M and N.
	// because "the shared equal part" are the final result after "& operation"
	// therefore, we right shift the two numbers m and n until they equal, then we
	// shift back i times to find the result.
	public int rangeBitwiseAnd(int m, int n) {
		int i = 0;
		while (m != n) {
			m >>>= 1;
			n >>>= 1;
			i++;
		}
		return (m << i);
	}

}
