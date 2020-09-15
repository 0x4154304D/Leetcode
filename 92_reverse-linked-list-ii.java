class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        for (int i = 1; i < m; ++i) {
            left = left.next;
        }
        ListNode right = left;
        for (int i = 0; i < (n - m) + 1; ++i) {
            right = right.next;
        }
        ListNode tmp = left.next;
        left.next = right.next;
        for (int i = 0; i < (n - m + 1); ++i) {
            ListNode temp = tmp.next;
            tmp.next = left.next;
            left.next = tmp;
            tmp = temp;
        }
        return dummy.next;
    }
}