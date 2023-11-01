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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode kAhead = head;
        ListNode kBehind = head;

        while (kAhead != null && n > 0) {
            kAhead = kAhead.next;
            n--;
        }
        if (kAhead == null) return head.next;

        while (kAhead.next != null) {
            kAhead = kAhead.next;
            kBehind = kBehind.next;
        }

        kBehind.next = kBehind.next.next;

        return head;
    }
}