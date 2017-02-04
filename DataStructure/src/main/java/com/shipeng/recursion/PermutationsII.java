package com.shipeng.recursion;

import java.util.HashSet;
import java.util.Set;

/*
 * String permutations with duplicate letters in input string.
 * 
 */


public class PermutationsII {

	public static void Permutation(char[] array, int index) {
		// base case
		if (index == array.length) {
			print(array);
			return;
		}
		Set<Character> used = new HashSet<Character>();
		for (int i = index; i < array.length; i++) {
			if (used.add(array[i])) {
				swap(array, i, index);
				Permutation(array, index+1);
				swap(array, i, index);
			}
		}
	}
	
	private static void swap(char[] array, int left, int right) {
		if (array == null || array.length == 0) {
			return;
		}
		
	    char temp = array[left];
	    array[left] = array[right];
	    array[right] = temp;
	}
	
	private static void print(char[] array) {
		for (char tmp : array) {
			System.out.print(tmp);
		}
		System.out.println();
	}
	
	
	
	public static void main(String[] args) {
		char[] array = new char[] { 'a', 'b', 'c' };
		Permutation(array, 0);
	}
	
}
