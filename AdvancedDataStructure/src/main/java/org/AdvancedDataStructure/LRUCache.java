package org.AdvancedDataStructure;

import java.util.*;

public class LRUCache {
	int capacity;
	Node head = null;
	Node tail = null;
	HashMap<Integer, Node> map;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<Integer, Node>();
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node n = map.get(key);
			remove(n);
			setHead(n);
			return n.value;
		}
		return -1;
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		} else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.key);
				remove(tail);
				setHead(created);
			} else {
				setHead(created);
			}
			map.put(key, created);
		}
	}

	public void setHead(Node n) {
		n.next = head;
		n.prev = null;
		if (head != null) {
			head.prev = n;
		}
		head = n;
		if (tail == null) {
			tail = head;
		}
	}

	public void remove(Node n) {
		if (n.prev != null) {
			n.prev.next = n.next;
		} else {
			head = n.next;
		}
		if (n.next != null) {
			n.next.prev = n.prev;
		} else {
			tail = n.prev;
		}
	}

	class Node {
		private Node prev = null;
		private Node next = null;
		private int key;
		private int value;

		public Node(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}

}