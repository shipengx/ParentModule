package com.shipeng.recursion;

/*
 * Print all valid permutations of () () ()
 * ( --- before we run out of (, we can always add (
 * ) --- only when we use more ( than ), we can add )
 * 
 */

public class PrintAllValidPermutationsOfParentheses {

	public static void permutation(int n) {
		if (n == 0) {
			return;
		}
		StringBuilder sb = new StringBuilder();
		helper(n, n, n, sb);
		return;
	}
	
	// helper method
	private static void helper(int left, int right, int n, StringBuilder sb) {
		if (sb.length() == 2 * n) {
			// base case
			System.out.println(sb.toString());
			return;
		}
		if (left > 0) {
			sb.append("(");
			helper(left-1, right, n, sb);
			sb.deleteCharAt(sb.length() -1);   // recover to the previous level
		}
		
		if (right > left) {
			sb.append(")");
			helper(left, right-1, n, sb);
			sb.deleteCharAt(sb.length()-1);
		}
	} // end helper method
	
	
	public static void main(String[] args) {
		
		permutation(4);
		
	} // end main
	
}
