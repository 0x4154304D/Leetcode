class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        while (cur != null) {
            boolean flag = false;
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
                flag = true;
            }
            if (flag) {
                pre.next = cur.next;
                cur = pre.next;
            } else {
                cur = cur.next;
                pre = pre.next;
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