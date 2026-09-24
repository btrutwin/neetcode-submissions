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
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            ListNode fastNext = fast.next.next;
            ListNode slowNext = slow.next;
            fast = fastNext;
            slow = slowNext;
            if(fast == slow){
                return true;
            }

        }     
        return false;
    }
}
