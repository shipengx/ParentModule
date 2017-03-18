package aa;

/*
 * Longest palindromic subsequence
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * 
 * Example 1:
 * input:
 * "bbbab"
 * 
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * 
 * Example 2:
 * input:
 * "cbbd"
 * output:
 * 2
 * 
 * One possible longest palindromic subsequence is "bb".
 * 
 * 
 */

public class LongestPalindromicSubsequence {
	
	public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int size = s.length();
        int[][] dp = new int[size][size];
        for (int i = size - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < size; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][size - 1];   
    }
}
