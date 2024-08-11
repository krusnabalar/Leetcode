import util.ListNode;

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;

        ListNode kAhead = head;
        int n = 1;

        while (kAhead.next != null) {
            kAhead = kAhead.next;
            n++;
        }
        if (k % n == 0)
            return head;
        kAhead.next = head;

        ListNode rotatedHead;
        k %= n;
        int newTailPos = n - 1 - k;
        for (int i = 0; i < newTailPos; i++)
            head = head.next;
        rotatedHead = head.next;
        head.next = null;

        return rotatedHead;
    }
}