/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m == n)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        for (int i = 0; i < m - 1; ++i) {
            cur = cur.next;
        }

        ListNode newHead = cur.next;
        ListNode tail = newHead;
        ListNode curr = newHead.next;
        ListNode tmp = null;
        for (int i = 0; i < n - m; ++i) {
            if (curr.next != null)
                tmp = curr.next;
            else
                tmp = null;
            curr.next = newHead;
            newHead = curr;
            curr = tmp;
        }

        cur.next = newHead;
        tail.next = curr;

        return dummy.next;
    }
}