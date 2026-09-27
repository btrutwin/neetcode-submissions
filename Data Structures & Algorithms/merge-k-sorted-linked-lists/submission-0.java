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
    public ListNode mergeKLists(ListNode[] lists) {
        // create a dummy node 
        // start by merging the 2 first sorted lists, then continue until array is empty 
        if(lists.length == 0){
            return null;
        }
        ListNode dummy = new ListNode();
        ListNode tail = dummy;
        tail.next = lists[0];
        // reset tail to dummy head
        // take next list of array and do the same thing until array is empty
        // need to keep track of tail.next since we will be inserting in middle of list and not just end
        for(int i = 1; i < lists.length; i++){
            tail = dummy;
            ListNode list = lists[i];
            while(list != null && tail.next != null){
                if(tail.next.val <= list.val){
                    tail = tail.next;
                }
                else{
                    ListNode next = tail.next; 
                    ListNode listNext = list.next;
                    tail.next = list; 
                    list.next = next;

                    tail = list;
                    list = listNext;
                }
            }
            if(tail.next == null){
                tail.next = list;
            }

        }
        return dummy.next;
    }
}
