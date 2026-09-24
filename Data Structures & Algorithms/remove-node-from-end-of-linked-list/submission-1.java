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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 0;
        ListNode traverse = head;
        while(traverse != null){
            count++;
            traverse = traverse.next;
        }
        count = count - n; // count now index needing to be removed
        ListNode curr = head;
        if(count == 0){
            head = head.next;
            return head;
        }
        while(curr != null){
            if(count == 1){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
            count--;
            
        }
        return head;
    }
}
