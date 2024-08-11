import util.ListNode;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode res = sum;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int value = carry;
            if (l1 != null) {
                value += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                value += l2.val;
                l2 = l2.next;
            }
            sum.next = new ListNode(value % 10);
            carry = value / 10;
            sum = sum.next;
        }

        return res.next;
    }
}