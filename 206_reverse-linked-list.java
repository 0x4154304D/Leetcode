/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
            ListNode tmp = cur;
            cur = cur.next;
            tmp.next = head;
            head = tmp;
        }
        return head;
    }
}