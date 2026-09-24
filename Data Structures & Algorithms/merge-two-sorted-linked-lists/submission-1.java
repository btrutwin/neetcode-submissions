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
        
        while(curr1ptr != null && curr2ptr != null){
            // 1 [1] -> [2] -> [4]
            // 2 [1] -> [3] -> [5]
            // need to save curr1 next
            // set tail.next to curr1 ptr 
            // update curr and tail to next 
            if(curr1ptr.val <= curr2ptr.val){
                ListNode next = curr1ptr.next;
                tail.next = curr1ptr; // [0]t -> [1]
                curr1ptr = next;
                tail = tail.next;
            }
            else{
                ListNode next = curr2ptr.next;
                tail.next = curr2ptr;
                curr2ptr = next;
                tail = tail.next;
            }
        }
        if(curr1ptr != null){
           tail.next = curr1ptr; 
        }
        else{
           tail.next = curr2ptr;
        }
        return dummy.next;
    }
}