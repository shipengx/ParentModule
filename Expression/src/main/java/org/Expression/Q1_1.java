package org.Expression;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author sxu
 * 
 * only + -
 * for example: "1 - 2 + 3" => 2
 * 12 + 3
 * 12
 *
 */

public class Q1_1 {

	public int evaluateExpression(String expression) {
		List<String> tokens = tokenize(expression);
		
		int accumulation = 0;
		boolean signIsPositive = true;
		String lastToken = null;
		for (String token : tokens) {
			if (lastToken != null && !(isOperator(lastToken) ^ isOperator(token))) {
				throw new IllegalArgumentException("Invalid expression: '%s' and '%s' should not be adjacent", lastToken, token));
			}
		}
		
	}
	
	private List<String> tokenize(String expression) {
		List<String> tokens = new ArrayList<String>();
		int i = 0;
		while (i < expression.length()) {
			char ch = expression.charAt(i);
			if (isOperator(ch)) {
				tokens.add(Character.toString(ch));
				i++;
			}else if (Character.isDigit(ch)) {
				String token = "";
				while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
					token += expression.charAt(i);
					i++;
				}
				tokens.add(token);
			}else if (Character.isLetter(ch)) {
				String token = "";
				while (i < expression.length() && Character.isLetterOrDigit(expression.chatAt(i))) {
					token += expression.charAt(i);
					i++;
				}
				tokens.add(token);
			}else {
				throw new IllegalArgumentException(String.format("Char '%c' is not allowed in an expression.", ch));
			}
		}
		
		return tokens;
	}
	
}
