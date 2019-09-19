package sf;

/**
 * Remove duplicates from sorted list
 *
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input:  1 -> 1 -> 2
 * Output: 1 -> 2
 *
 * Example 2:
 * Input:  1 -> 1 -> 2 -> 3 -> 3
 * Output: 1 -> 2 -> 3
 *
 */

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.next.val == current.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}
