package aa;

/*
 * Palindrome linked list
 * 
 * Given a singly linked list, determine if it is a palindrome
 * 
 * Follow up:
 * Could you do it in O(n) time and O(1) space ?
 * 
 */

public class PalindromeLinkedList {

	public boolean isPalindrome(ListNode head) {
		if (head == null) {
			return true;
		}
		ListNode middle = findMiddle(head);
		middle.next = reverseList(middle.next);
		ListNode p1 = head, p2 = middle.next;
		while (p1 != null && p2 != null && p1.val == p2.val) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2 == null;
	}

	private ListNode findMiddle(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode slow = head, fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	private ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode next = head.next;
		ListNode newHead = reverseList(next);
		next.next = head;
		head.next = null;
		return newHead;
	}

}
