package aa;

/*
 * Given an integer number n, find its integer square root.
 * Assumption:
 * n is guaranteed to be >= 0.
 * Example:
 * Input: 18, Return: 4
 * Input: 4, Return: 2
 * 
 */

public class Sqrt {

	public int sqrt(int x) {
		// find the last number which square of it <= x
		long start = 1, end = x;
		while (start + 1 < end) {
			long mid = start + (end - start) / 2;
			if (mid * mid <= x) {
				start = mid;
			} else {
				end = mid;
			}
		}

		if (end * end <= x) {
			return (int) end;
		}
		return (int) start;
	}

}
