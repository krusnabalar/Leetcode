/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        Set<Integer> uniqueValues = new HashSet<>();
        Set<Integer> repeatingValues = new HashSet<>();

        ListNode secondTraversal = head;
        ListNode result = head;
        while (head != null) {
            if (!uniqueValues.add(head.val))
                repeatingValues.add(head.val);
            head = head.next;
        }
        ListNode prev = null;
        while (secondTraversal != null) {
            if (repeatingValues.contains(secondTraversal.val)) {
                if (prev == null) {
                    result = result.next;
                } else {
                    prev.next = secondTraversal.next;
                }
            } else {
                prev = secondTraversal;
            }
            secondTraversal = secondTraversal.next;
        }
        return result;
    }
}