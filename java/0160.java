import util.ListNode;

class Solution {
    int lenA;
    int lenB;

    public int findLen(ListNode head) {
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }

        return len;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = findLen(headA);
        int lenB = findLen(headB);
        int diff = Math.abs(lenA - lenB);
        // catch up to other
        for (int i = 0; i < diff; i++) {
            if (lenA < lenB) {
                headB = headB.next;
            } else {
                headA = headA.next;
            }
        }

        while (headA != null || headB != null) {
            if (headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}