/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

// 1
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        while (head != null && head.val == val)
            head = head.next;
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.next.val == val) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        return head;
    }
}

// sentinel
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;

        ListNode prev = sentinel, curr = head;
        while (curr != null) {
            if (curr.val == val)
                prev.next = curr.next;
            else
                prev = curr;
            curr = curr.next;
        }
        return sentinel.next;
    }
}