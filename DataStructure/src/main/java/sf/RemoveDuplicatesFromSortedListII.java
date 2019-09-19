package sf;


/**
 * Remove duplicates from Sorted List II
 *
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 *
 * Example 1:
 *     Input: 1 -> 2 -> 3 -> 3 -> 4 -> 4 -> 5
 *     Output: 1 -> 2 -> 5
 *
 * Example 2:
 *     Input: 1->1->1->2->3
 *     Output: 2->3
 *
 */




public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode tmp = dummy;
        while (tmp.next != null && tmp.next.next != null) {
            if (tmp.next.val == tmp.next.next.val) {
                int dup = tmp.next.val;
                while (tmp.next != null && tmp.next.val == dup) {
                    tmp.next = tmp.next.next;
                }
            } else {
                tmp = tmp.next;
            }
        }
        return dummy.next;
    }

}
