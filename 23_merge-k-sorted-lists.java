/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

//Brute
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(true){
            ListNode minNode = null;
            int minIndex = -1;
            for (int i = 0; i < lists.length; ++i){
                if (lists[i] == null){
                    continue;
                }
                if (minNode == null || lists[i].val < minNode.val){
                    minNode = lists[i];
                    minIndex = i;
                }
            }
            if (minIndex == -1) break;
            cur.next = minNode;
            cur = minNode;
            lists[minIndex] = lists[minIndex].next;
        }
        return dummy.next;
    }
}


//Heap
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> pq = new PriorityQueue<>((v1, v2) -> v1.val - v2.val);
        for (ListNode node: lists) {
            if (node != null) {
                pq.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            cur.next = minNode;
            cur = minNode;
            if (minNode.next != null) {
                pq.offer(minNode.next);
            }
        }
        return dummy.next;
    }
}