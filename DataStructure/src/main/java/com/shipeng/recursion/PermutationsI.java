package com.shipeng.recursion;

import java.util.ArrayList;
import java.util.List;

public class PermutationsI {
	
	public static List<String> permutations(String set) {
		List<String> result = new ArrayList<String>();
		if (set == null) {
			return result;
		}
		char[] array = set.toCharArray();
		helper(array, 0, result);
		return result;
	}
	
	
	private static void helper(char[] array, int index, List<String> result) {
		// terminate condition:
		// only when we have already chosen the characters for all the position,
		// we can have a complete permutation
		if (index == array.length) {
			result.add(new String(array));
			return;
		}
		// all the possible characters could be placed at index are the characters in the subarray(index, array.length-1);
		for (int i = index; i < array.length; i++) {
			swap(array, i, index);
			helper(array, index+1, result);
			swap(array, i, index);
		}
	}
	
	private static void swap(char[] array, int left, int right) {
		char tmp = array[left];
		array[left] = array[right];
		array[right] = tmp;
	}
	
	
	public static void main(String[] args) {
		
		String s1 = "abc";
		List<String> list = permutations(s1);
		System.out.println(list);
		
	} // end main
	
	
}
