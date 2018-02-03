package com.ti.class10;

/*
 * String abbreviation matching
 * Word "book" can be abbreviated to 4, b3, b2k etc.
 * Given a string and an abbreviation, return if the string matches the abbreviation.
 * 
 * Assumptions:
 *     The original string only contains alphabetic characters.
 *     Both input and pattern are not null.
 * 
 * Examples
 *     pattern "s11d" matches input "sophisticated" since "11" matches eleven chars "ophisticate"
 * 
 */

public class StringAbbreviationMatching {

	public boolean match(String input, String pattern) {
		// Write your solution here.
		// Assumptions: input, pattern are not null,
		return match(input, pattern, 0, 0);
	}

	private boolean match(String s, String t, int si, int ti) {
		// only when we run out of s and t at the same time, there is a match.
		if (si == s.length() && ti == t.length()) {
			return true;
		}

		// if we run out of one of s and t
		// but there is still some characters left for the other one,
		// we can not find the match
		if (si >= s.length() || ti >= t.length()) {
			return false;
		}

		// case1. if the current character in t is not a digit.
		if (t.charAt(ti) < '0' || t.charAt(ti) > '9') {
			if (s.charAt(si) == t.charAt(ti)) {
				return match(s, t, si + 1, ti + 1);
			}
			return false;
		}

		// case2. if the current character in t is a digit.
		// we need to find in total what is the number.
		// e.g. "123" means number 123.
		int count = 0;
		while (ti < t.length() && t.charAt(ti) >= '0' && t.charAt(ti) <= '9') {
			count = count * 10 + (t.charAt(ti) - '0');
			ti++;
		} // end while

		return match(s, t, si + count, ti);
	}

}
