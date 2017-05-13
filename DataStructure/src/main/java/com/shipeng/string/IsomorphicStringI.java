package com.shipeng.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same 
 * character but a character may map to itself.
 * 
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 * 
 * Note:
 * You may assume both s and t have the same length.
 * 
 */

public class IsomorphicStringI {

	public boolean isIsomorphic(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		if (s.length() != t.length()) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();

		for (int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (map.containsKey(c1)) {
				if (map.get(c1) != c2) {
					// if not consistent with previous ones
					return false;
				}
			} else {
				if (map.containsValue(c2)) {
					// if c2 is already being mapped
					return false;
				}
				map.put(c1, c2);
			}
		}
		return true;
	}

}
