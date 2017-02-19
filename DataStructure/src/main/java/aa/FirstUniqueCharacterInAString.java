package aa;

/*
 * Given a string, find the first non-repeating character in it and return its index.
 * if it doesn't exist,
 * return -1.
 * 
 * 
 */

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
		int freq[] = new int[26];
		for (int i = 0; i < s.length(); i++)
			freq[s.charAt(i) - 'a']++;
		for (int i = 0; i < s.length(); i++)
			if (freq[s.charAt(i) - 'a'] == 1)
				return i;
		return -1;
	}

}
