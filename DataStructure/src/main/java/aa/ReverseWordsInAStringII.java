package aa;

/*
 * Given an input string, reverse the string word by word.
 * A word is defined as a sequence of non-space characters.
 * 
 * The input String does not contain leading or trailing spaces and the words
 * are always separated by a single space.
 * 
 * For example,
 * Given s = " the sky is blue ",
 * return " blue is sky the ".
 * Could you do it in-place without allocating extra space ?
 * 
 */

public class ReverseWordsInAStringII {
	
	public static void reverseWords(char[] s) {
        if (s == null || s.length == 0) {
            return;
        }
        reverse(s, 0, s.length-1);
        int start = 0;
        for (int i = 0; i < s.length; i++) {
        	//set start index
            if (s[i] != ' ' && (i == 0 || s[i-1] == ' ')) {
                start = i;
            } 
            //set end index
            if (s[i] != ' ' && (i == s.length-1 || s[i+1] == ' ')) {
                reverse(s, start, i);
            }
        }
    }
    
    private static void reverse(char[] array, int left, int right) {
        if (array == null || array.length == 0) {
            return;
        }
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }
    
    public static void main(String[] args) {
    	char[] s = new char[] { 'a', ' ', 'b' };
    	reverseWords(s);
    	System.out.println(s);
    }
	
}
