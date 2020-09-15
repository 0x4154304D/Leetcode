class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;
        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }
        int helflen = (len + 1) >> 1;
        cur = head;
        for (int i = 0; i < helflen; ++i) {
            cur = cur.next;
        }
        ListNode newHead = new ListNode(0);
        while (cur != null) {
            ListNode newNode = new ListNode(cur.val);
            newNode.next = newHead.next;
            newHead.next = newNode;
            cur = cur.next;
        }
        newHead = newHead.next;
        ListNode dummy = new ListNode(0);
        cur = head;
        int count = 1;
        while (newHead != null) {
            ListNode tmp = newHead.next;
            newHead.next = cur.next;
            cur.next = newHead;
            cur = cur.next;
            ++count;
            if (count == len) {
                break;
            } else {
                cur = cur.next;
                ++count;
            }
            newHead = tmp;
        }
        cur.next = null;
    }
}