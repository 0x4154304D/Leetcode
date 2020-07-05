/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        while (cur1 != null || cur2 != null) {
            int x = 0, y = 0;
            if (cur1 != null) {
                x = cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                y = cur2.val;
                cur2 = cur2.next;
            }
            int tmp = x + y + carry;
            carry = tmp / 10;
            ListNode newNode = new ListNode(tmp % 10);
            cur.next = newNode;
            cur = cur.next;
        }
        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            cur.next = newNode;
        }
        return head.next;
    }
}