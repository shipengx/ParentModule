package com.shipeng.bit;

/*
 * Power of Two
 * Given an integer, write a function to determine if it is a power of two.
 * 
 */

public class PowerOfTwo {

	// method 1
	public boolean isPowerOfTwo1(int n) {
		// if a number is power of 2, then its highly bit is 1 and there is only one 1.
		// therefore, n & (n-1) is 0.
		return n > 0 && (n & n - 1) == 0;
	}

	// method 2
	public boolean isPowerOfTwo2(int n) {
		int cnt = 0;
		while (n > 0) {
			cnt = cnt + (n & 1);
			n >>= 1; // shift right by 1
		}
		return cnt == 1;
	}
}
