package sf;

/**
 * Reverse words in a String
 *
 * Given an input string, reverse the string word by word.
 *
 * Example 1:
 * input: "the sky is blue"
 * output: "blue is sky the"
 *
 * Example 2:
 * input: "  hello world!  "
 * output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 *
 * Example 3:
 * input: "a good    example"
 * output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 * Note :
 * a word is defined as a sequence of non-space characters.
 * input string may contain leading or trailing spaces, however, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 */

public class ReverseWordsInAStringII {

    // method 1:
    public String reverseWords(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }
        s = s.trim();
        char[] charArray = s.toCharArray();
        swap(charArray, 0, charArray.length - 1);

        int start = 0;
        for (int i = 0; i < charArray.length; i++) {
            // set start index
            if (charArray[i] != ' ' && (i == 0 || charArray[i-1] == ' ')) {
                start = i;
            }
            // set end index
            if (charArray[i] != ' ' && (i == charArray.length - 1 || charArray[i+1] == ' ')) {
                swap(charArray, start, i);
            }
        }

        String result = new String(charArray);
        result = result.replaceAll("\\s+", " ");
        return result;
    }

    private void swap(char[] charArray, int i, int j) {
        if (charArray == null || charArray.length == 0) {
            return;
        }
        while (i < j) {
            char tmp = charArray[i];
            charArray[i] = charArray[j];
            charArray[j] = tmp;
            i++;
            j--;
        }
    }

    // method 2:
    public String reverseWordsII(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        s = s.trim();
        String[] words = s.split(" ");
        for (int i = words.length-1; i >= 0; i--) {
            if (!words[i].equals("")) {
                sb.append(words[i]).append(" ");
            }
        }
        return sb.toString().trim();
    }


}
