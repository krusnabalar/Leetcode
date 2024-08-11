import util.ListNode;

class Solution {
    ListNode front;

    public boolean isPalindrome(ListNode head) {
        front = head;
        return recurse(head);
    }

    public boolean recurse(ListNode curr) {
        if (curr == null)
            return true;
        if (!recurse(curr.next) || curr.val != front.val)
            return false;
        front = front.next;
        return true;
    }
}