package com.shipeng.math;

/*
 * There are 2 sorted arrays A and B of size n each. 
 * Write an algorithm to find the median of the array obtained after merging the above 2 arrays
 * The complexity should be O(log(n))
 * 
 * Algorithm:
 * 1) calculate the medians m1 and m2 of the input arrays ar1[] and ar2[] respectively.
 * 2) if m1 and m2 both are equal then we are done.
 *        return m1 (or m2)
 * 3) if m1 is greater than m2, then median is present in one of the below two subarrays.
 *       a) from first element of ar1 to m1 (ar1[0.... | n/2_|]
 *       b) from m2 to last element of ar2 (ar2[n/2 ... n-1])
 * 4) if m2 is greater than m1, then median is present in one of the below two subarrays.
 *       a) from m1 to last element of ar1 (ar1[n/2 ... n-1])
 *       b) from first element of ar2 to m2 (ar2[0... n/2])
 * 5) repeat the above process until size of both the subarrays becomes 2.
 * 6) if size of the two array is 2 then use below formula to get the median.
 *       median = (max(ar1[0], ar2[0]) + min(ar1[1], ar1[1]))/2
 *       
 * Example:
 * ar1[] = {1, 12, 15, 26, 38}
 * ar2[] = {2, 13, 17, 30, 45}
 * 
 * 
 * 
 */


public class MedianOfTwoSortedArrays {

	public static float getMedian2(int[] a1,int[] a2){
		int end = a1.length-1;
		return _getMedian2(a1,0,end,a2,0,end);
	}
 
	private static float _getMedian2(int[] a1, int s1,int e1, int[] a2,int s2, int e2){
		//System.out.println("("+a1[s1]+","+a1[e1]+") to ("+a2[s2]+","+a2[e2]+")");
		int len = e1-s1+1;
		if(len <= 0)
			return -1;
		if(len == 1)
			return (a1[s1]+a2[s2])/2.0f;
		if(len == 2)
			return (Math.max(a1[s1],a2[s2])+Math.min(a1[e1],a2[e2]))/2.0f;
		float m1 = getM(a1,s1,e1);
		float m2 = getM(a2,s2,e2);
		if(m1 == m2)
			return m1;
 
		if(m1 < m2){
			if(len%2 == 0)
				return _getMedian2(a1,s1+(len/2),e1, a2,s2,s2+(len/2)-1);
			return _getMedian2(a1,s1+(len/2),e1, a2,s2,s2+(len/2));
		}
 
		if(len%2 == 0)
			return _getMedian2(a1,s1,s1+(len/2)-1, a2,s2+(len/2),e2);
		return _getMedian2(a1,s1,s1+(len/2), a2,s2+(len/2),e2);
	}
	
	private static float getM(int[] arr, int s, int e) {
		int len = e-s+1;
		int i = len/2;
		if (len%2 == 0) {
			return (arr[i] + arr[i+1])/2.0f;
		}
		return arr[i];
	}
	
	
	public static void main(String[] args) {
		int[] a1 = new int[]{1, 3, 5, 7, 9};
		int[] a2 = new int[]{2, 4, 6, 8, 10};
		System.out.println("O(logn) -> "+getMedian2(a1,a2));
	} // end main

} //end class
