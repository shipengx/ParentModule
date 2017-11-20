package org.Fundamentals;

/**
 * 
 * @author sxu
 *
 *         Java bit manipulation
 * 
 *         The unary bitwise complement operator "~" inverts a bit pattern; it
 *         can be applied to any of the integral types, making every "0" a "1"
 *         and Every "1" a "0".
 * 
 *         The signed left shift operator "<<" shifts a bit pattern to the left,
 *         and the signed right shift operator ">>" shifts a bit pattern to the
 *         right. the Bit pattern is given by the left-hand operand, and the
 *         number of positions to shiftby the right-hand operand. the unsigned
 *         right shift operator ">>>" shifts a zero into the leftmost position,
 *         while the leftmost position after ">>" depends on sign
 */

public class JavaBit {

	public static void main(String[] args) {
		int i = 1;
		// left shift by 3
		i = i << 3;
		System.out.println("i : " + i);

		// you can use a third shift operator called "unsigned shift right" operator >>>
		// for always shift in a "0" regardless of the sign.
		// unsigned right shift by 2
		i = i >>> 2;
		System.out.println("i : " + i);
	}

}
