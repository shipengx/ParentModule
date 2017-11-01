package org.Fundamentals;

import java.util.BitSet;

/**
 * 
 * @author sxu
 * 
 *         The BitSet class creates a special type of array that holds bit
 *         values. The bitSet array can increase in size as needed. This makes
 *         it similar to a vector of bits. This is a legacy class but it has
 *         been completely re-engineered in java.
 * 
 *         BitSet() This constructor creates a default object.
 * 
 *         BitSet(size) this constructor allows you to specify its initial size,
 *         i.e., the number of bits that it can hold. All bits are initialized
 *         to zero.
 * 
 *         void and(BitSet bitSet) ANDs the contents of the invoking BitSet
 *         object with those specified by bitSet. The result is placed into the
 *         invoking object.
 * 
 *         void clear() zeros all bits.
 * 
 *         void clear(int index) zeros the bit specified by index.
 * 
 *         void flip(int index) Reverses the bit specified by the index.
 * 
 *         boolean get(index) returns the current state of the bit at the
 *         specified index.
 * 
 *         boolean isEmpty() Returns true if all bits in the invoking object are
 *         zero.
 * 
 *         int nextClearBit(int startIndex) returns the index of the next
 *         cleared bit, (that is, the next zero bit), starting from index
 *         specified by startIndex.
 * 
 *         int nextSetBit(int startIndex) returns the index of the next set bit
 *         (that is, the next 1 bit), starting from the index specified by
 *         startIndex. If no bit is set, -1 is returned.
 * 
 *         void or(BitSet bitSet) ORs the contents of the invoking BitSet object
 *         with that specified by bitSet. the result is placed into the invoking
 *         object.
 * 
 *         int size() returns the number of bits in the invoking BitSet object
 * 
 *         void xor(BitSet bitSet) XORs the contents of the invoking BitSet
 *         object with that specified by bitSet. the result is placed into the
 *         invoking object.
 * 
 *         void set(int index) Set the bit specified by index.
 * 
 *         void set(int index, boolean v) Sets the bit specified by index to the
 *         value passed in v. True sets the bit, false clears the bit.
 * 
 */
public class BitSetTest {

	public static void main(String[] args) {
		BitSet bitSet1 = new BitSet();
		BitSet bitSet2 = new BitSet();

		// setup above two BitSets
		setupBitSets(bitSet1, bitSet2);

		System.out.println("Initial pattern in bitSet1: ");
		System.out.println(bitSet1);
		System.out.println("\nInitial pattern in bitSet2: ");
		System.out.println(bitSet2);

		// AND bits
		bitSet2.and(bitSet1);
		System.out.println("\nbits2 AND bits1: ");
		System.out.println(bitSet2);

		// setup above two BitSets
		setupBitSets(bitSet1, bitSet2);

		// OR bits
		bitSet2.or(bitSet1);
		System.out.println("\nbits2 OR bits1: ");
		System.out.println(bitSet2);

		// setup above two BitSets
		setupBitSets(bitSet1, bitSet2);

		// XOR bits
		bitSet2.xor(bitSet1);
		System.out.println("\nbits2 XOR bits1: ");
		System.out.println(bitSet2);

	}

	private static void setupBitSets(BitSet bitSet1, BitSet bitSet2) {

		bitSet1.set(5);
		bitSet1.set(3);
		bitSet1.set(1);

		bitSet2.set(5);
		bitSet2.set(7);
		bitSet2.set(9);
	}

}
