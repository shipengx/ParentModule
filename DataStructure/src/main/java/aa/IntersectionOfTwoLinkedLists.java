package aa;

import java.util.HashSet;
import java.util.Set;

/*
 * Intersection of two linked lists
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:   a1 --> a2
 *   
 *                          c1 --> c2 --> c3
 * 
 *      b1 --> b2 --> b3
 * 
 * begin to intersect at node c1.
 * 
 * Notes:
 *     if the two linked lists have no intersection at all, return null.
 *     the linked lists must retain their original structure after the function returns.
 *     you may assume there are no cycles anywhere in the entire linked structure.
 *     your code should preferably run in O(n) time and use only O(1) memory.
 * 
 */

public class IntersectionOfTwoLinkedLists {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		Set<ListNode> set = new HashSet<ListNode>();

		while (headA != null) {
			set.add(headA);
			headA = headA.next;
		}

		while (headB != null) {
			if (!set.add(headB)) {
				return headB;
			}
			headB = headB.next;
		}

		return null;

	}

}
