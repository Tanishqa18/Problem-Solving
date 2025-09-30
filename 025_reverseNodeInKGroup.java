/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k==1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prevGroupEnd = dummy;

        while(true){
            ListNode kth = getkthNode(prevGroupEnd, k);
            if (kth == null)break;
            ListNode groupstart = prevGroupEnd.next;
            ListNode nextGroupStart = kth.next;
            reverse (groupstart, kth);
            prevGroupEnd.next = kth;
            groupstart.next = nextGroupStart;
            prevGroupEnd = groupstart;
        }
        return dummy.next;
        
    }
    private ListNode getkthNode(ListNode node, int k){
         while (node != null && k > 0) {
            node = node.next;
            k--;
        }
        return node;
    }

    private void reverse (ListNode start, ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        ListNode stop = end.next;

        while(curr != stop){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }
}
