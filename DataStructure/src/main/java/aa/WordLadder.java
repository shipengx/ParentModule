package aa;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * Word ladder
 * 
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,

 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.

 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * UPDATE (2017/1/20):
 * The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.
 * 
 */

public class WordLadder {

	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Set<String> dict = new HashSet<String>();
		for (String word : wordList) {
			dict.add(word);
		}

		if (beginWord.equals(endWord)) {
			return 1;
		}

		Set<String> visited = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		queue.offer(beginWord);
		visited.add(beginWord);

		int steps = 1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String st = queue.remove();
				if (st.equals(endWord)) {
					return steps;
				} else {
					for (int j = 0; j < st.length(); j++) {
						StringBuffer sb = new StringBuffer(st);
						for (int k = 0; k < 26; k++) {
							sb.setCharAt(j, (char) ('a' + k));
							String next = sb.toString();
							if (dict.contains(next) && !visited.contains(next)) {
								queue.add(next);
								visited.add(next);
							}
						}
					}
				}
			}
			steps++;
		} // end while

		return 0;
	}

}
