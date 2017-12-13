package com.shipeng.bit;

/*
 * Maximum XOR of two numbers in an array.
 * 
 * Given a non-empty array of numbers a0, a1, a2, ..., an-1, where 0 <= ai < 2^31.
 * Find the maximum result of ai XOR aj, where 0 <= i, j < n.
 * Could you do this in O(n) time ?
 * 
 * Example:
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 * 
 */

public class MaximumXORofTwoNumbersInAnArray {

	// Naive solution (time complexity: O(N^2)
	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int max = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				int xor = nums[i] ^ nums[j];
				max = Math.max(max, xor);
			}
		}
		return max;
	}

	// Better solution (solve with a trie, time complexity: O(N)
	class BitTrie {
		class Node {
			Node zero;
			Node one;
		}

		Node root;

		public BitTrie() {
			root = new Node();
		}

		public int add(int num) {
			Node current = root;
			Node xor = root;
			int value = num;
			int mask = 1 << 30;
			while (mask != 0) {
				boolean currentBit = (num & mask) != 0;
				boolean xorBit = xor != null && (!currentBit || xor.zero == null) && xor.one != null;

				value ^= xorBit ? mask : 0;

				current = nextNode(current, currentBit);
				xor = (xor != null ? (xorBit ? xor.one : xor.zero) : null);

				mask >>>= 1;
			}
			return value;
		}

		private Node nextNode(Node node, boolean one) {
			if (one && node.one == null) {
				node.one = new Node();
			} else if (!one && node.zero == null) {
				node.zero = new Node();
			}
			return one ? node.one : node.zero;
		}

	}

	public int findMaximumXOR2(final int[] nums) {
		if (nums.length < 2) {
			return 0;
		}

		BitTrie trie = new BitTrie();
		trie.add(nums[0]);

		int result = Integer.MIN_VALUE;
		for (int i = 1; i < nums.length; i++) {
			result = Math.max(result, trie.add(nums[i]));
		}
		return result;
	}

}
