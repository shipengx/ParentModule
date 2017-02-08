package com.shipeng.medium;

/*
 * One Edit Distance
 * 
 * Determine if two given Strings are one edit distance.
 * One edit distance means you can only insert one character/delete one character/replace one character to another 
 * character in one of the two given Strings and they will become identical.
 * 
 * Assumptions:
 *     the two given Strings are not null.
 * Examples:
 * s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical
 * s = "abc", t = "bcd" are not one edit distance.
 * 
 */

public class OneEditDistance {
	
	public boolean oneEditDistance(String s, String t) {
		if (s == null || t == null) {
			return false;
		}
		if (Math.abs(s.length() - t.length()) > 1) {
			return false;
		}
		int m = s.length();
		int n = t.length();
		if (m == n) {
			return isOneModified(s,t);
		}
		if (m-n == 1) {
			return isOneDeleted(s,t);
		}
		if (n-m == 1) {
			return isOneDeleted(t,s);
		}
		return false;
	}
	
	private boolean isOneModified(String s, String t) {
		boolean modified = false;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != t.charAt(i)) {
				if (modified) {
					return false;
				}
				modified = true;
			}
		}
		return modified;
	}
	
	private boolean isOneDeleted(String longer, String shorter) {
		for (int i = 0; i < shorter.length(); i++) {
			if (longer.charAt(i) != shorter.charAt(i)) {
				return longer.substring(i+1).equals(shorter.substring(i));
			}
		}
		return true;
	}
	
}
