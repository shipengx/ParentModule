package com.ti.class26;

/*
 * Median of Two sorted arrays
 * 
 * Given two sorted arrays of integers in ascending order, 
 * find the median value.
 * 
 * Assumptions:
 *     The two given arrays are not null and at least one of them is not empty
 *     the two given arrays are guaranteed to be sorted
 *    
 * Examples:
 *     A = {1, 4, 6}, B = {2, 3}, median is 3
 *     A = {1, 4}, B = {2, 3}, median is 2.5
 * 
 * 
 */

public class MedianOfTwoSortedArrays {

	public static double median(int[] a, int[] b) {
		// Write your solution here
		int m = a.length;
		int n = b.length;

		if ((m + n) % 2 != 0) // odd
			return (double) findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1);
		else { // even
			return (findKth(a, b, (m + n) / 2, 0, m - 1, 0, n - 1) + findKth(a, b, (m + n) / 2 - 1, 0, m - 1, 0, n - 1))
					* 0.5;
		}
	}

	public static int findKth(int A[], int B[], int k, int aStart, int aEnd, int bStart, int bEnd) {

		int aLen = aEnd - aStart + 1;
		int bLen = bEnd - bStart + 1;

		// Handle special cases
		if (aLen == 0)
			return B[bStart + k];
		if (bLen == 0)
			return A[aStart + k];
		if (k == 0)
			return A[aStart] < B[bStart] ? A[aStart] : B[bStart];

		int aMid = aLen * k / (aLen + bLen); // a's middle count
		int bMid = k - aMid - 1; // b's middle count

		// make aMid and bMid to be array index
		aMid = aMid + aStart;
		bMid = bMid + bStart;

		if (A[aMid] > B[bMid]) {
			k = k - (bMid - bStart + 1);
			aEnd = aMid;
			bStart = bMid + 1;
		} else {
			k = k - (aMid - aStart + 1);
			bEnd = bMid;
			aStart = aMid + 1;
		}

		return findKth(A, B, k, aStart, aEnd, bStart, bEnd);
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 5, 8, 9, 10, 11};
		int[] b = new int[] {2,3,4};
		System.out.println("median is: " + median(a,b));
	}

}
