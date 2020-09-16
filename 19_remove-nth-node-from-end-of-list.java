//Single Point
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int size = 0;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            ++size;
        }
        size -= n;
        cur = dummy;
        for (int i = 0; i < size; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return dummy.next;
    }
}

// Double Point
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        for (int i = 0; i < n; ++i) {
            fast = fast.next;
        }
        ListNode slow = dummy;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}