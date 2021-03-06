package com.shipeng.bit;

/*
 * Counting bits
 * Given a non negative integer number num.
 * For every numbers i in the range of 0 <= i <= num calculate the number of 1's in their binary representation and return them as an array.
 * 
 * Example:
 * For num = 5 you should return [0, 1, 1, 2, 1, 2].
 * 
 * Follow up:
 *     it is very easy to come up with a solution with run time O(n * sizeof(integer)).
 *     But can you do it in linear time O(n)/possibly in a single pass ?
 *     Space complexity should be O(n).
 *     Can you do it like a boss ? Do it without using any builtin function like __builtin_popcount in C++ in any other language.
 * 
 */

public class CountingBits {

	// method 2
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			// one number * 2 equals one number << 1, therefore, after * 2 its number of 1 bit remains the same,
			// therefore, we just need to check the lowest bit to see if it is 1, that's it.
			res[i] = res[i >> 1] + (i & 1);
		}
		return res;
	}

}
