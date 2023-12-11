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
    public ListNode partition(ListNode head, int x) {
        ListNode front = head;
        ListNode tail = head;

        while (head != null) {
            ListNode next = head.next;
            if (head.val < x) {
                head.next = front;
                front = head;
            } else {
                tail.next = head;
                tail = head;
            }
            head = next;
        }
        tail.next = null;
        return front;
    }
}