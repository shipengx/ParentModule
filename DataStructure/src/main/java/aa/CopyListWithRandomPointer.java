package aa;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

	// Method 1: using HashMap to avoid copy multiple times for the same node,
	public RandomListNode copy1(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// Dummy node to help construct the deep copy.
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode cur = dummy;
		//maintains the mapping between the node in the original list and 
		// the corresponding node in the new list.
		Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
		while (head != null) {
			// copy the current node if necessary
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
		} //end while
		
		return dummy.next;
	}
	
	// Method 2: Another three pass solution, not using HashMap, 
	// but changing the original list structure during the copy 
	// (it will be changed back at the end).
	public RandomListNode copyII(RandomListNode head) {
		if (head == null) {
			return null;
		}
		// First pass, for each node in the original list, insert a copied node 
		// between the node and node.next
		RandomListNode cur = head;
		while (cur != null) {
			// Make a copy of cur node, insert it to the middle of cur and cur.next.
			RandomListNode copy = new RandomListNode(cur.label);
			copy.next = cur.next;
			cur.next = copy;
			cur = cur.next.next;
		}
		// second pass, link the random pointer for the copied one.
		cur = head;
		while (cur != null) {
			if (cur.random != null) {
				cur.next.random = cur.random.next;
			}
			cur = cur.next.next;
		}
		// third pass, extract the copied node.
		cur = head;
		RandomListNode dummy = new RandomListNode(0);
		RandomListNode copyPrev = dummy;
		while (cur != null) {
			copyPrev.next = cur.next;
			cur.next = cur.next.next;
			copyPrev = copyPrev.next;
			cur = cur.next;
		}
		return dummy.next;
	}
}
