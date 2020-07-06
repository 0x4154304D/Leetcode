/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null)
            return head;
        ListNode less = new ListNode(0);
        ListNode newNode = less;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null) {
            if (cur.next.val < x) {
                ListNode tmp = cur.next.next;
                newNode.next = cur.next;
                cur.next.next = null;
                newNode = cur.next;
                cur.next = tmp;
                continue;
            }
            cur = cur.next;
        }
        if (less.next != null) {
            newNode.next = dummy.next;
            head = less.next;
        }
        return head;
    }
}