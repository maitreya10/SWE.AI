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
    public void reorderList(ListNode head) {
        //Find middle of the List using Slow and Fast Pointers.
        ListNode fast = head.next;
        ListNode slow = head;
        // There could be Null pointer due the conditional statement in the While Loop;
        // Hence fast != null should preceed fast.next!= null
        while ( fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // At this point, One possibility where fast == null;
        // Ans another possibilty, that fast.next = null;

        //Reverse the second half of th elIst using a tmp variable
        // The second half start from slow.next
        ListNode second = slow.next;
        ListNode prev = slow.next = null;
        while (second != null) {
            ListNode tmp = second.next;
            second.next = prev;
            prev = second;
            second = tmp;
        }

        // Now only merging is remaining
        // Merge the 2 halves (Reassign the Pointers)
        // Remember prev contains the head on of the reversed list.
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode tmp1 = first.next;
            first.next = second;
            ListNode tmp2 = second.next;
            second.next = tmp1;
            first = tmp1;
            second = tmp2;
        }
        
    }
}
