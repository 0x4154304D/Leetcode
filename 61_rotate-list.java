//connect a ring
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0)
            return head;
        int size = 1;
        ListNode cur = head;
        while (cur.next != null) {
            ++size;
            cur = cur.next;
        }
        k %= size;
        if (k == 0)
            return head;

        cur.next = head;
        cur = head;
        for (int i = 0; i < size - k - 1; ++i) {
            cur = cur.next;
        }
        head = cur.next;
        cur.next = null;
        return head;
    }
}

// new SingleList
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        int len = getSize(head);
        k %= len;
        if (k == 0)
            return head;
        ListNode cur = head;
        for (int i = 0; i < (len - k) - 1; ++i) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        cur = newHead;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = head;
        return newHead;
    }

    private static int getSize(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            ++len;
        }
        return len;
    }
}