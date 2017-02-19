package aa;

import java.util.List;

/*
 * Word break
 * 
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words. You may assume the dictionary does not contain duplicate words.
 * For example, given
 * s = "leetcode", dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * 
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 *
 */

public class WordBreak {

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0) {
			return true;
		}

		boolean[] m = new boolean[s.length()];
		// m[i] represents whether we can break the words from index 0 to ith
		// index, including ith index.
		// base case:
		if (wordDict.contains(s.substring(0, 1))) {
			m[0] = true;
		}

		for (int i = 0; i < s.length(); i++) {
			// if the whole word is in the dictionary, simply set to true and go
			// to next one.
			if (wordDict.contains(s.substring(0, i + 1))) {
				m[i] = true;
				continue;
			}

			// linear scan and look back at all the positions.
			for (int j = 0; j < i; j++) {
				String str = s.substring(j + 1, i + 1); // substring from j+1 to
														// i+1, second part.
				if (m[j] && wordDict.contains(str)) {
					m[i] = true;
					break;
				}
			}
		}

		return m[s.length() - 1];

	}

}
