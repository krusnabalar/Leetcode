import util.ListNode;

class Solution {
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null)
            return head;
        int n = 0;
        ListNode temp = head;

        while (temp.next != null) {
            temp = temp.next;
            n++;
        }

        n = (n + 1) / 2;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;
    }
}