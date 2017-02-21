package aa;

public class LongestSubstringWithoutRepeatingCharacters {

	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		int[] map = new int[256]; // map from character's ASCII to its last
									// occurred index

		int j = 0;
		int answer = 0;
		for (int i = 0; i < s.length(); i++) {
			while (j < s.length() && map[s.charAt(j)] == 0) {
				map[s.charAt(j)] = 1;
				answer = Math.max(answer, j - i + 1);
				j++;
			}
			map[s.charAt(i)] = 0;
		}

		return answer;
	}

}
