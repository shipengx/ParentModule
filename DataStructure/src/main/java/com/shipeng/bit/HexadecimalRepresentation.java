package com.shipeng.bit;

/*
 * Hexadecimal representation
 * 
 * Generate the hexadecimal representation for a given non-negative integer number as a string.
 * the hex representation should start with "0x".
 * 
 * There should not be extra zeros on the left side.
 * 
 * Examples
 * 0's hex representation is "0x0"
 * 255's hex representation is "0xFF"
 * 
 */

public class HexadecimalRepresentation {

	public String hex(int number) {
		// write your solution here
		String prefix = "0x";
		// handle the special case of 0 first.
		if (number == 0) {
			return prefix + "0";
		}
		// using stringbuilder so append operation is more efficient.
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int rem = number % 16;
			if (rem < 10) {
				sb.append((char) ('0' + rem));
			} else {
				sb.append((char) (rem - 10 + 'A'));
			}
			number >>>= 4;
		}
		// reverse it at last so in all complexity is O(n).
		return prefix + sb.reverse().toString();
	}

}
