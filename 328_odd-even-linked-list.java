class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode s = new ListNode(0);
        ListNode d = new ListNode(0);
        ListNode curs = s, curd = d;
        ListNode cur = head;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = curs.next;
            curs.next = cur;
            curs = curs.next;
            cur = tmp;
            if (cur != null) {
                tmp = cur.next;
                cur.next = curd.next;
                curd.next = cur;
                curd = curd.next;
                cur = tmp;
            }
        }
        curs.next = d.next;
        return s.next;
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
