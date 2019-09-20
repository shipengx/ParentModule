package sf;

import java.util.HashMap;
import java.util.Map;

/**
 * Implement trie (Prefix tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 *
 * Example:
 *
 * Trie trie = new Trie();
 *
 * trie.insert("apple");
 * trie.search("apple");     // return true
 * trie.search("app");       // return false
 * trie.startsWith("app");   // returns true
 * trie.insert("app");
 * trie.search("app");       // returns true
 *
 * Note :
 * you may assume that all inputs are consisted of lowercase letters a-z.
 * all inputs are guaranteed to be non-empty strings.
 *
 */

public class ImplementTrie {

    private Node root;

    public ImplementTrie() {
        root = new Node();
    }


    // inserts a word into the trie
    public void insert(String word) {
        Map<Character, Node> children = root.children;

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            Node t;
            if (children.containsKey(c)) {
                t = children.get(c);
            } else {
                t = new Node(c);
                children.put(c, t);
            }

            children = t.children;
            // set leaf node
            if (i == word.length() - 1) {
                t.isLeaf = true;
            }
        }
    }

    public Node searchNode(String str) {
        Map<Character, Node> children = root.children;
        Node t = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            } else {
                return null;
            }
        }
        return t;
    }

    // returns if the word is in the trie
    public boolean search(String word) {
        Node t = searchNode(word);
        if (t != null && t.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

    // returns if any word in the trie that starts with the given prefix
    public boolean startsWith(String prefix) {
        if (searchNode(prefix) == null) {
            return false;
        } else {
            return true;
        }
    }

}


class Node {
    char c;
    Map<Character, Node> children = new HashMap<Character, Node>();
    boolean isLeaf;

    public Node() {
    }

    public Node(char c) {
        this.c = c;
    }
}