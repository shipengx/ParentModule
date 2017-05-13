package bihui;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement Trie (Prefix Tree) Implement a trie with insert, search, and
 * startsWith methods.
 * 
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 *
 */

class TrieNode {
	char ch;
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isWord;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.ch = c;
	}
}

public class ImplementTrie {

	private TrieNode root;

	/** Initialize your data structure here. */
	public ImplementTrie() {
		root = new TrieNode();
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (search(word)) {
			return;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode next = cur.children.get(word.charAt(i));
			if (next == null) {
				// new TrieNode
				// insert into the children map
				next = new TrieNode();
				cur.children.put(word.charAt(i), next);
			}
			// jump to th new node
			cur = next;
		}
		// set isEnd
		cur.isWord = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return true;
		}
		TrieNode cur = root;
		for (int i = 0; i < word.length(); i++) {
			TrieNode next = cur.children.get(word.charAt(i));
			if (next == null) {
				return false;
			}
			cur = next;
		}
		return cur.isWord;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given
	 * prefix.
	 */
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return true;
		}
		TrieNode cur = root;
		for (int i = 0; i < prefix.length(); i++) {
			TrieNode next = cur.children.get(prefix.charAt(i));
			if (next == null) {
				return false;
			}
			cur = next;
		}
		return true;
	}
}


/**
 * Ordering: 
 * 	A trie can provide an alphabetical ordering of the entries by key. Why?
 *  class TrieNode {
 *  	char c -> 
 *      //suppose we have 26 characters, each character mapped to one of the index (length 26)
 *      TrieNode[] children;
 *      Map<Character, TrieNode> children;
 *      boolean isEnd;
 *      // other information
 *      
 *  }
 * 
 * Sorted arrayList    yes
 * hashMap             no
 * binary search tree  yes
 * 
 * 
 * 
 * Space:
 *     if the trie is not too sparse, since reusing the common prefix as many as possible, less
 *     space required, worst case O(nm), but usually much better than this.
 *     
 * 
 * Trie's drawbacks
 * time: 1) if stored on disk, more random disk accesses (very expensive)
 * space: 1) every TrieNode has extra space consumption --> extra space usage
 *        2) memory allocation fragmentation
 * Especially when the trie is sparse.
 * 
 * Use case
 * String or sequence typed elements
 * fast search/add/delete
 * grouping common prefix, both for time/space complexity
 * problems related to prefix/matching
 * 
 * Implementation
 * Assumptions: charset only contains 26 lower case english characters.
 * class TrieNode {
 *     TrieNode[] children;   // size 26 array, each index -> character, 
 *     boolean isWord;
 * }
 * 
 * or 
 * 
 * class TrieNode {
 *     Map<Character, TrieNode> children;   // map the character to the corresponding child
 *     boolean isWord;
 * }
 * 
 * 
 */







