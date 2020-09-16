// 1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getSize(headA), lenB = getSize(headB);
        ListNode curA = headA, curB = headB;
        if (lenA > lenB) {
            for (int i = 0; i < (lenA - lenB); ++i) {
                curA = curA.next;
            }
        } else {
            for (int i = 0; i < (lenB - lenA); ++i) {
                curB = curB.next;
            }
        }
        while (curA != null && curB != null && curA != curB) {
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }

    private static int getSize(ListNode head) {
        ListNode cur = head;
        int size = 0;
        while (cur != null) {
            ++size;
            cur = cur.next;
        }
        return size;
    }
}

// 2
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
}