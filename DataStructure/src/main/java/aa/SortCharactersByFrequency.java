package aa;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Sort characters by frequency
 * 
 * Given a string, sort it in decreasing order based on the frequency of characters.
 * 
 * Example 1:
 *     Input:
 *     "tree"
 *     
 *     Output:
 *     "eert"
 *     
 *     Explanation:
 *     'e' appears twice while 'r' and 't' both appear once.
 *     So 'e' must appear before both 'r' and 't'. Therefore 'eetr" is also a valid answer.
 *     
 * Example 2:
 *     Input:
 *     "cccaaa"
 *     
 *     Output:
 *     "cccaaa"
 *     
 *     Explanation:
 *     Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 *     Note that "cacaca" is incorrect, as the same characters must be together.
 *     
 * Example 3:
 *     Input:
 *     "Aabb"
 *     
 *     Output:
 *     "bbAa"
 *     
 *     Explanation:
 *     "bbaA" is also a valid answer, but "Aabb" is incorrect.
 *     Note that 'A' and 'a' are treated as two different characters.
 * 
 */

public class SortCharactersByFrequency {

	public String frequencySort(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
		PriorityQueue<Node> maxHeap = new PriorityQueue<Node>(new Comparator<Node>() {
			public int compare(Node n1, Node n2) {
				if (n1.getFreq() < n2.getFreq())
					return 1;
				if (n1.getFreq() > n2.getFreq())
					return -1;
				return 0;
			}
		});
		Map<Character, Node> map = new HashMap<Character, Node>();
		for (char c : s.toCharArray()) {
			if (!map.containsKey(c)) {
				Node newNode = new Node(c, 1);
				map.put(c, newNode);
			} else {
				Node tmp = map.get(c);
				tmp.setFreq(tmp.getFreq() + 1);
				map.put(c, tmp);
			}
		}
		for (Node n : map.values()) {
			maxHeap.add(n);
		}
		StringBuilder sb = new StringBuilder();
		while (!maxHeap.isEmpty()) {
			Node tmp = maxHeap.poll();
			for (int i = 0; i < tmp.getFreq(); i++) {
				sb.append(tmp.getChar());
			}
		}

		return sb.toString();

	}

	private class Node {
		public char character;
		public int freq;

		public Node(char c, int f) {
			this.character = c;
			this.freq = f;
		}

		public int getFreq() {
			return this.freq;
		}

		public void setFreq(int freq) {
			this.freq = freq;
		}

		public char getChar() {
			return this.character;
		}
	}

}
