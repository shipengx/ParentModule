package com.shipeng.bit;

/*
 * Number complement
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * 
 * Note:
 * 1. the given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * 2. you could assume no leading zero bit in the integer's binary representation.
 * 
 * Example 1:
 * Input: 5
 * Input: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits)
 *     and its complement is 010. So you need to output 2.
 * 
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0.
 * So you need to output 0.
 * 
 */

public class NumberComplement {

	public static int findComplement(int num) {
		int result = ~num & ((Integer.highestOneBit(num) << 1) - 1);
		return result;
	}

	public static void main(String[] args) {
		int num = 5;
		int result = findComplement(num);
		System.out.println("result is : " + result);
	}

}
