/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
        ListNode cur = head;
        int size = 0;
        while (cur != null){
            ++size;
            cur = cur.next;
        }
        int halfSize = (size + 1) / 2;
        cur = head;
        for (int i = 1; i < halfSize; ++i){
            cur = cur.next;
        }
        ListNode stop = cur.next;
        cur.next = null;
        ListNode newHead = stop;
        cur = stop.next;
        newHead.next = null;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = newHead;
            newHead = cur;
            cur = tmp;
        }
        ListNode revCur = newHead;
        cur = head;
        ListNode tmpA = null, tmpB = null;
        while (cur != null || revCur != null){
            tmpA = cur.next;
            cur.next = revCur;
            cur = tmpA;
            if (revCur != null){
                tmpB = revCur.next;
                revCur.next = cur;
                revCur = tmpB;
            } 
        }
    }
}