/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        dummy.next = head;
        ListNode cur = head;
        ListNode pre = dummy;
        while (cur != null && cur.next != null) {
            if (cur.val != cur.next.val) {
                pre = cur;
                cur = cur.next;
                continue;
            }
            while (cur.val == cur.next.val) {
                cur.next = cur.next.next;
                if (cur.next == null) {
                    pre.next = cur.next;
                    break;
                }
                if (cur.val != cur.next.val) {
                    pre.next = cur.next;
                    cur = cur.next;
                    break;
                }
            }
        }
        return dummy.next;
    }
}

// 2
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode dummy = new ListNode(Integer.MAX_VALUE);
        ListNode tail = dummy;
        for (ListNode l = head, r = head; l != null; l = r) {
            while (r != null && r.val == l.val)
                r = r.next;
            if (l.next == r) {
                tail.next = l;
                tail = l;
                tail.next = null;
            }
        }
        return dummy.next;
    }
}