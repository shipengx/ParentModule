package com.shipeng.bit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Repeated DNA Sequences
 * 
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G and T,
 * for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences with the DNA.
 * 
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecure.
 * 
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * 
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * 
 */

public class RepeatedDNASequences {

	// method 1: brute force method (loop through all the subsequences and get
	// counts for them)
	public List<String> findRepeatedDnaSequences(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 10)
			return result;

		Map<String, Integer> counterMap = new HashMap<>();

		for (int i = 0; i < s.length() - 9; i++) {
			String key = s.substring(i, i + 10);
			int value = counterMap.getOrDefault(key, 0);
			counterMap.put(key, value + 1);
		}

		for (Map.Entry<String, Integer> entry : counterMap.entrySet()) {
			if (entry.getValue() > 1) {
				result.add(entry.getKey());
			}
		}
		return result;
	}

	// method 2: bit manipulation
	public List<String> findRepeatedDnaSequencesII(String s) {
		List<String> result = new ArrayList<>();
		if (s == null || s.length() < 10) {
			return result;
		}
		char[] map = new char[256];
		map['A'] = 0;
		map['C'] = 1;
		map['G'] = 2;
		map['T'] = 3;
		int mask = 0xfffff;
		int val = 0;
		char[] charArray = s.toCharArray();
		for (int i = 0; i < 9; i++) {
			val = (val << 2) | (map[charArray[i]] & 3);
		}
		byte[] bytes = new byte[1 << 20];
		for (int i = 9; i < charArray.length; i++) {
			val = ((val << 2) & mask) | ((map[charArray[i]]) & 3);
			if (bytes[val] == 1) {
				result.add(String.valueOf(charArray, i - 9, 10));
			}
			if (bytes[val] < 2) {
				bytes[val]++;
			}
		}
		return result;
	}

}
