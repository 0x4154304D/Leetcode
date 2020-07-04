/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; next = null; } }
 */

// 1
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        if (headA == headB)
            return headA;
        ListNode curA = headA, curB = headB;
        int sizeA = 1, sizeB = 1;
        boolean hasCommonNode = false;
        while (curA.next != null || curB.next != null) {
            if (curA.next != null) {
                curA = curA.next;
                ++sizeA;
            }
            if (curB.next != null) {
                curB = curB.next;
                ++sizeB;
            }
            if (curA == curB) {
                hasCommonNode = true;
            }
        }
        if (!hasCommonNode)
            return null;
        curA = headA;
        curB = headB;
        int index = 0;
        if (sizeA > sizeB) {
            index = sizeB;
            for (int i = 0; i < sizeA - sizeB; ++i) {
                curA = curA.next;
            }
        } else {
            index = sizeA;
            for (int i = 0; i < sizeB - sizeA; ++i) {
                curB = curB.next;
            }
        }
        for (int i = 0; i < index; ++i) {
            if (curA == curB)
                break;
            curA = curA.next;
            curB = curB.next;
        }
        return curA;
    }
}

//2
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