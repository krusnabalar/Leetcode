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
    class PartialSum {
        public ListNode sum = null;
        public int carry = 0;

        PartialSum() {
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);

        if (len1 < len2) {
            l1 = padList(l1, len2 - len1, 0);
        } else {
            l2 = padList(l2, len1 - len2, 0);
        }
        len1 = length(l1);
        len2 = length(l2);

        PartialSum total = addTwoNumbersRecurse(l1, l2);

        if (total.carry == 0)
            return total.sum;
        return padList(total.sum, 1, total.carry);
    }

    private PartialSum addTwoNumbersRecurse(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return new PartialSum();
        }

        PartialSum sumOfPrev = addTwoNumbersRecurse(l1.next, l2.next);

        int val = l1.val + l2.val + sumOfPrev.carry;
        sumOfPrev.sum = padList(sumOfPrev.sum, 1, val % 10);
        sumOfPrev.carry = val / 10;

        return sumOfPrev;
    }

    private ListNode padList(ListNode l, int size, int val) {
        if (size == 0)
            return l;
        ListNode padder = new ListNode(val);
        ListNode padding = padder;
        while (size > 1) {
            padder.next = new ListNode(val);
            padder = padder.next;
            size--;
        }
        padder.next = l;
        return padding;
    }

    private int length(ListNode l) {
        int count = 0;
        while (l != null) {
            count++;
            l = l.next;
        }
        return count;
    }
}