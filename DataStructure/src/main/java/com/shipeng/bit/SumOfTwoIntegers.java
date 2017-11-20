package com.shipeng.bit;

/*
 * Sum of Two integers
 * Calculate the sum of two integers a and b,
 * but you are not allowed to use the operator + and -.
 * 
 * Example:
 * Given a = 1 and b = 2, return 3.
 * 
 * 
 */

public class SumOfTwoIntegers {

	public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;
            a = a ^ b;
            b = carry;
        }
        return a;
    }
	
	public static void main(String[] args) {
		int a = 5;
		int b = 7;
		System.out.println("after XOR operation: " + (a^b));
	}
}
