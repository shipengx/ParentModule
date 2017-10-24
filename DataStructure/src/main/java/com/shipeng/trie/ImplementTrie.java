package com.shipeng.trie;

/*
 * Implement Trie (Prefix Tree)
 * 
 * Implement a trie with insert, search and startsWith methods.
 * Note:
 * You may assume that all inputs consist of lowercase letters like "a-z".
 * 
 */

class TrieNode {
	public TrieNode[] children = new TrieNode[26];
	public boolean isWord;
}

public class ImplementTrie {
	private TrieNode root;
	
	/** Initialize your data structure here. */
	public ImplementTrie() {
		root = new TrieNode();
	}
	
	/** Inserts a word into the trie */
	public void insert(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode();
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}
	
	/** returns if the word is in the trie. */
	public boolean search(String word) {
		TrieNode node = root;
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		return node != null && node.isWord;
	}
	
	/** returns if there is any word in the trie that starts with the given prefix */
	public boolean startsWith(String prefix) {
		TrieNode node = root;
		for (char c : prefix.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				return false;
			}
			node = node.children[c - 'a'];
		}
		return true;
	}
	
}
