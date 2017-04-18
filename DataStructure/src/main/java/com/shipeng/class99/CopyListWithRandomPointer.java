package com.shipeng.class99;

import java.util.HashMap;
import java.util.Map;

/**
 * Copy list with random pointer
 * 
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 *
 */

public class CopyListWithRandomPointer {
	
	private class RandomListNode {
	    int label;
	    RandomListNode next, random;
	    RandomListNode(int x) { this.label = x; }
	};
	
	public RandomListNode copyRandomList(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// dummy node to help construct the deep copy
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		// Maintains the mapping between the node in the original list and
		// the corresponding node in the new list.
		Map<RandomListNode, RandomListNode> map = new HashMap<>();
		while (head != null) {
			// copy the current node if necessary.
			if (!map.containsKey(head)) {
				map.put(head, new RandomListNode(head.label));
			}
			// Connect the copied node to the deep copy list.
			cur.next = map.get(head);
			// copy the random node if necessary.
			if (head.random != null) {
				if (!map.containsKey(head.random)) {
					map.put(head.random, new RandomListNode(head.random.label));
				}
				// Connect the copied node to the random pointer.
				cur.next.random = map.get(head.random);
			}
			head = head.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
