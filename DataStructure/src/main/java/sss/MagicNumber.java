package sss;

/*
 * Magic number
 * A magic number is one that can be represented as a sum of a set of unique number that are equal to 
 * powers of 7. For example 56 = 7^2 + 7^1.
 * Return the k-th smallest magic number.
 * For example:
 * 1,7,8,49,50,56,57....
 * 
 */

public class MagicNumber {

	// Assume k > 0, limit >= 1, limit < base
	public int magic(int k, int base, int limit) {
		int res = 0;
		int b = 1;
		while (k != 0) {
			res += (k % (limit + 1)) * b;
			k /= (limit + 1);
			b *= base;
		}
		return res;
	}
	
}

