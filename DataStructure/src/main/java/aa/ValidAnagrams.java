package aa;

/*
 * Valid Anagram
 * 
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t="nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * what if the input contains unicode character? 
 * How would you adapt your solution to such case?
 * 
 */

public class ValidAnagrams {

	public boolean isAnagram(String s, String t) {
		if (s == null || t == null) {
			return false;
		}

		if (s.length() != t.length()) {
			return false;
		}

		int[] array = new int[26];
		for (int i = 0; i < s.length(); i++) {
			array[s.charAt(i) - 'a']++;
			array[t.charAt(i) - 'a']--;
		}

		for (int i : array) {
			if (i != 0) {
				return false;
			}
		}

		return true;
	}

}
