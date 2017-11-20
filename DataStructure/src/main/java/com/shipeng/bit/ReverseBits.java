package com.shipeng.bit;

/*
 * Reverse bits
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * 
 * Follow up:
 * If this function is called many times, how would you optimize it ?
 * 
 * Analysis:
 * This is a very basic bit manipulation problem.
 * 
 * in this problem, the first task is to get the binary bits from unit number n.
 * let's say n = 43261596, the binary format is: 00000010100101000001111010011100.
 * in order to get the binary bits, mask is used here.
 * the idea of using mask to check 1 bit each time, using AND operation.
 * 
 * Mask moves 1 bit each time using << operation.
 * Mask can be computed and saved before to speed up the reverse function.
 * 
 * E.g
 * iteration 1: mask = 0000...00001, then mask & n = 0
 * iteration 2: mask = 0000...00010, then mask & n = 0
 * iteration 3: mask = 0000...00100, then mask & n = 1
 * iteration 4: mask = 0000...01000, then mask & n = 1
 * ......
 * iteration 32: mask = 1000...00000, then mask & n = 0
 * 
 * in this way, binary bits can be obtained from 32 iterations.
 * Reverse thus becomes pretty easy when using this looping.
 * 
 * The next step is to convert bits back into integer.
 * Bit shift is all we need.
 * in this problem, we check the original int from the lowest bit to highest, so the first bit in the original int
 * is the highest bit in the result int.
 * By shifting the final int 1 bit each time, the final int after 31 (32-1) times shifting, it becomes the reverse
 * int of the original int. 32 is the length of the int data type in this problem.
 * 
 */

public class ReverseBits {

	// you need to treat n as an unsigned value
	public int reverseBits(int n) {
		int result = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				result = result + 1;
			}
			if (i != 31) {
				result = result << 1;
			}
			// shift and change mask for next higher bit check
			mask = mask << 1;
		}

		return result;
	}
	
	public static void main(String[] args) {
		int n = 43261596;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((n & mask) != 0) {
				System.out.print("1");
			}else {
				System.out.print("0");
			}
			mask = mask << 1;
		}
	}

}
