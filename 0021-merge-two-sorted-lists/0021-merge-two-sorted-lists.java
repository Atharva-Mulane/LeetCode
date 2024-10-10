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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // Create a temporary node to form the merged list
        ListNode temp_node = new ListNode(0);
        ListNode curr_node = temp_node;
        
        // Traverse both lists and compare each node
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                curr_node.next = l1;
                l1 = l1.next;
            } else {
                curr_node.next = l2;
                l2 = l2.next;
            }
            curr_node = curr_node.next;  // Move to the next node
        }
        
        // Append the remaining part of the non-null list (if any)
        if (l1 != null) {
            curr_node.next = l1;
        } else if (l2 != null) {
            curr_node.next = l2;
        }
        
        // Return the merged list, which starts at temp_node.next
        return temp_node.next;
    }
}
