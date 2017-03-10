package aa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Letter combinations of a phone number
 * 
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 
 * Input: Digit String "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"],
 * 
 * Note:
 * Although the above answer is in lexicographical order,
 * your answer could be in any order you want.
 * 
 * 
 */

public class LetterCombinationsOfAPhoneNumber {

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return result;
		}

		StringBuilder sb = new StringBuilder();
		Map<Integer, String> dict = new HashMap<Integer, String>();
		dict.put(2, "abc");
		dict.put(3, "def");
		dict.put(4, "ghi");
		dict.put(5, "jkl");
		dict.put(6, "mno");
		dict.put(7, "pqrs");
		dict.put(8, "tuv");
		dict.put(9, "wxyz");

		helper(dict, sb, result, 0, digits);
		return result;
	}

	private void helper(Map<Integer, String> dict, StringBuilder sb, List<String> result, int index, String digits) {
		if (index == digits.length()) {
			result.add(sb.toString());
			return;
		}
		String tmpStr = dict.get(Character.getNumericValue(digits.charAt(index)));
		for (int i = 0; i < tmpStr.length(); i++) {
			char tmpChar = tmpStr.charAt(i);
			sb.append(tmpChar);
			helper(dict, sb, result, index + 1, digits);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
