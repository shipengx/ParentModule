package com.shipeng.math;

/*
 * Median of two sorted arrays of different sizes
 * This is an extension of median of two sorted arrays of equal size problem.
 * Here we handle arrays of unequal sizes also.
 * 
 * Method 1:
 * This problem can be converted to the problem of finding kth element, k is (A's length + B's lenghth)/2.
 * 
 * If any of the two arrays is empty, then the kth element is the non-empty array's kth element.
 * If k == 0, the kth element is the first element of A or B.
 * 
 * For normal cases (all other cases), 
 * we need to move the pointer at the pace of half of the array size to get log(n) time.
 * 
 * 
 *       section 1               v1               section 2
 *    a0, ....................., ak/2-1, .........., am-1
 *    
 *       section 3               v2               section 4
 *    b0, ....................., bk/2-1, .........., bn-1
 *    
 *    if v1 > v2
 *        drop section 3 & search (k - k/2)th in the rest
 *    if v1 < v2
 *        drop section 1 & search (k- k/2) th in the rest
 * 
 * Method 2:
 * The approach discussed in this post is similar to method 2 of equal size post.
 * THe basic idea is the same, 
 * we find the median of two arrays and compare the medians to discard almost half of the elements in both arrays.
 * Since the number of elements may differ here, there are many base cases that need to be handled separately.
 * Before we proceed to complete solution, let us first talk about all base cases.
 * 
 * Let the two arrays be A[N] and B[M]. In the following explanation, it is assumed that N is smaller or equal to M.
 * 
 * Base cases:
 * The smaller array has one one element
 * case 0 : N = 0, M = 2
 * case 1: N = 1, M = 1
 * case 2: N = 1, M is odd
 * case 3: N = 1, M is even
 * The smaller array has only two elements
 * case 4: N = 2, M = 2
 * case 5: N = 2, M is odd
 * case 6: N = 2, M is even
 * 
 * 
 * 
 * 
 */

public class MedianOfTwoSortedArraysDifferentSizes {

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int total = nums1.length + nums2.length;
		if (total%2 == 0) {
			return (findKth(total/2+1, nums1, nums2, 0, 0) + findKth(total/2, nums1, nums2, 0, 0))/2.0;
		}else {
			return findKth(total/2+1, nums1, nums2, 0, 0);
		}
	}
	
	public static int findKth(int k, int[] nums1, int[] nums2, int s1, int s2) {
		if (s1 >= nums1.length) {
			return nums2[s2+k-1];
		}
		if (s2 >= nums2.length) {
			return nums1[s1+k-1];
		}
		if (k == 1) {
			return Math.min(nums1[s1], nums2[s2]);
		}
		
		int m1 = s1 + k/2-1;
		int m2 = s2 + k/2-1;
		
		int mid1 = m1 < nums1.length?nums1[m1]:Integer.MAX_VALUE;
		int mid2 = m2 < nums2.length?nums2[m2]:Integer.MAX_VALUE;
		
		if (mid1 < mid2) {
			return findKth(k- k/2, nums1, nums2, m1+1, s2);
		}else {
			return findKth(k - k/2, nums1, nums2, s1, m2+1);
		}
	}
	
	
	
	
	public static void main(String[] args) {
		int[] array1 = new int[] { 1, 3, 5, 7, 9};
		int[] array2 = new int[] { 2, 6, 8 };
		double median = findMedianSortedArrays(array1, array2);
		System.out.println("median of two sorted arrays: " + median);
	}
	
	
}
