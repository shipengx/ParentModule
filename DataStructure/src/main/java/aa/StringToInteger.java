package aa;

/*
 * String to integer (atoi)
 * 
 * Implement atoi to convert a string to an integer.
 * Hint: carefully consider all possible input cases.
 * if you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * 
 * Notes: it is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * 
 */

public class StringToInteger {

	public int myAtoi(String str) {
		if (str == null || str.length() == 0) {
			return 0;
		}
		
		str = str.trim();
		char flag = '+';
		
		//check negative or positive
		int i = 0;
		if (str.charAt(0) == '-') {
			flag = '-';
			i++;
		}else {
			i++;
		}
		
		// use double to save result
		double result = 0;
		
		// calculate value
		while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
			result = result * 10 + (str.charAt(i) - '0');
			i++;
		}
		
		if (flag == '-') {
			result = -result;
		}
		
		// handle max and min
		if (result > Integer.MAX_VALUE) {
			return Integer.MAX_VALUE;
		}
		
		if (result < Integer.MIN_VALUE) {
			return Integer.MIN_VALUE;
		}
		
		return (int)result;	
	}
}
