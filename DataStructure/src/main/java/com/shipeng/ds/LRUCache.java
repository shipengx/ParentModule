package com.shipeng.ds;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author sxu
 *
 * Design and implement a data structure for least recently used (LRU) cache.
 * It should support the following operations: get and set.
 * get(key) -- get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1
 * set(key, value) -- set or insert the value if the key is not already present. 
 * When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * 
 */

class Node {
	int key;
	int value;
	Node prev;
	Node next;
	
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}


public class LRUCache {
	int capacity;
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	Node head = null;
	Node tail  = null;
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
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
	
	public void remove(Node n) {
		if (n.prev != null) {
			n.prev.next = n.next;
		}else {
			head = n.next;
		}
		
		if (n.next != null) {
			n.next.prev = n.prev;
		}else {
			tail = n.prev;
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
	
	public void set(int key, int value) {
		if (map.containsKey(key)) {
			Node old = map.get(key);
			old.value = value;
			remove(old);
			setHead(old);
		}else {
			Node created = new Node(key, value);
			if (map.size() >= capacity) {
				map.remove(tail.key);
				remove(tail);
				setHead(created);
			}else {
				setHead(created);
			}
			map.put(key, created);
		}
	}
	
} // end class LRUCache










