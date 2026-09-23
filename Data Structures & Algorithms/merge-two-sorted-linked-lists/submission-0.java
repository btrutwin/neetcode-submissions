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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        ListNode curr1ptr = list1;
        ListNode curr2ptr = list2;
        ListNode next = null;
        while(curr1ptr != null && curr2ptr != null){
            
            if(curr1ptr.val <= curr2ptr.val){
                next = curr1ptr.next;
                tail.next = curr1ptr;
                curr1ptr = next;
                tail = tail.next; 
            }
            else{
                next = curr2ptr.next;
                tail.next = curr2ptr;
                curr2ptr = next;
                tail = tail.next;
            }
        }
        if (curr1ptr != null) {
            tail.next = curr1ptr;
        } else {
            tail.next = curr2ptr;
        }
        return dummy.next;
        
    }
}