package bihui;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Boggle game:
 * Given a matrix of characters, you can move from one cell to neighbor cell (up, down, left, right).
 * on the same path, each cell can be used only once.
 * Find all possible words that can be formed by a sequence of adjacent characters.
 * 
 * dictionary = {"at", "app", "apple", "cap", "cat", "cathy", "dog"},
 * 
 * APPD
 * PPLG
 * OGEI
 * DKLM
 * 
 * Output: {"app", "apple", "dog"}
 * 
 * Time complexity:
 * M * n matrix
 * length of the word i l
 * size of the dictionary is k
 * O(kl + mn * 4^l)
 * 
 * vs.
 * 
 * Time complexity: O(kmn * 4 ^ l) (trie)
 *
 */


public class BoggleGame {

	static final int[][] DIRS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public List<String> findWords(char[][] board, String[] words) {
		List<String> result = new ArrayList<>();
		// sanity check
		if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
			return result;
		}
		// step one --> build the Trie from the given list of words.
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		TrieNode root = trie.root;

		final int rows = board.length;
		final int cols = board[0].length;
		StringBuilder sb = new StringBuilder();
		// from every cell try to find the word corresponding to the part start
		// from the current cell.
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dfs(root, board, i, j, sb, result);
			}
		}

		return result;
	}

	private static void dfs(TrieNode root, char[][] board, int x, int y, StringBuilder sb, List<String> result) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
			return;
		}
		char ch = board[x][y];
		// if the current cell has been consumed by previous character, or the
		// dict has no more characters
		// can match the current path, we should return
		if (ch == '#' || root.children[ch - 'a'] == null) {
			return;
		}
		root = root.children[ch - 'a'];
		sb.append(ch);
		if (root.isWord) {
			result.add(sb.toString());
			root.isWord = false;
		}

		board[x][y] = '#';
		for (int[] dir : DIRS) {
			int neiX = dir[0] + x;
			int neiY = dir[1] + y;
			dfs(root, board, neiX, neiY, sb, result);
		}
		board[x][y] = ch;
		sb.deleteCharAt(sb.length() - 1);
	}

	// Trie Node
	class TrieNode {
		public TrieNode[] children = new TrieNode[26];
		public boolean isWord;
	}

	// Trie
	class Trie {
		public TrieNode root = new TrieNode();

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

		public boolean search(String word) {
			TrieNode node = root;
			for (char c : word.toCharArray()) {
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return node != null && node.isWord;
		}

		public boolean startsWith(String prefix) {
			TrieNode node = root;
			for (char c : prefix.toCharArray()) {
				if (node.children[c - 'a'] == null)
					return false;
				node = node.children[c - 'a'];
			}
			return true;
		}
	}
}
