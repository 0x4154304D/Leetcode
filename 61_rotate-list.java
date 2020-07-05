/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++size;
            cur = cur.next;
        }
        k %= size;
        if (k == 0)
            return head;
        cur.next = head;
        cur = head;
        for (int i = 0; i < size - k - 1; ++i) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}