import util.ListNode;

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode res = head;
        while (head != null && head.val == val) {
            res = head.next;
            head = head.next;
        }

        while (head != null && head.next != null) {
            ListNode temp = head.next;
            while (temp != null && temp.val == val) {
                temp = temp.next;
            }

            head.next = temp;
            head = head.next;
        }

        return res;
    }
}