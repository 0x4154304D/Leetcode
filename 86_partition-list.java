class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        ListNode lessList = new ListNode(0);
        ListNode l = lessList;
        while (cur.next != null) {
            if (cur.next.val < x) {
                l.next = cur.next;
                l = l.next;
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        l.next = dummy.next;
        return lessList.next;
    }
}