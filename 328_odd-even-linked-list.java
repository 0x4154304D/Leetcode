/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode oddNode = head;
        ListNode evenNode = head.next;
        ListNode tmp = evenNode;
        ListNode cur = evenNode.next;
        while (cur != null) {
            oddNode.next = cur;
            oddNode = oddNode.next;
            if (cur.next != null) {
                cur = cur.next;
            } else {
                break;
            }
            tmp.next = cur;
            tmp = tmp.next;
            cur = cur.next;
        }
        oddNode.next = evenNode;
        tmp.next = null;
        return head;
    }
}

// Easy way
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head, even = head.next, evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
