package aa;

/*
 * Merge two sorted lists
 * 
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 */

public class MergeTwoSortedLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(-1);
		ListNode curr = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				curr.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			curr = curr.next;
		}
		if (l1 != null) {
			curr.next = l1;
		}
		if (l2 != null) {
			curr.next = l2;
		}
		return dummy.next;
	}

}
