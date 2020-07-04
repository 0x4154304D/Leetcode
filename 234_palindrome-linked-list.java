/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }
        int halfSize = size / 2;
        ListNode halfHead = head;
        head = head.next;
        halfHead.next = null;
        for (int i = 1; i < halfSize; ++i) {
            ListNode tmp = head.next;
            head.next = halfHead;
            halfHead = head;
            head = tmp;
        }

        if (size - halfSize * 2 == 1) {
            head = head.next;
        }
        ListNode cur1 = head;
        ListNode cur2 = halfHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val != cur2.val) {
                return false;
            }
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return true;
    }
}