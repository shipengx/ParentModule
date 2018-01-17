package com.shipeng.bit;

/*
 * All Unique Characters I
 * 
 * Determine if the characters of a given String are all unique.
 * 
 * Assumptions:
 *     the only set of possible characters used in the string are 'a' - 'z', the 26 lowercase letters.
 *     the given string is not null.
 *     
 * Examples:
 *     the characters used in "abcd" are unique
 *     the characters used in "aba" are not unique
 * 
 */

public class AllUniqueCharactersI {

	public boolean allUnique(String word) {
		// an integer is good enough to store (26 lowercase letters)
		int result = 0;
		char[] array = word.toCharArray();
		for (char c : array) {
			if (((result >> c) & 1) == 1) {
				return false;
			}
			result |= 1 << c;
		}
		return true;
	}
}
