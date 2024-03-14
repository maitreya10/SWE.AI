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
    // Iterative Approach
    // TC: O(n), SC: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0, head);
        // the node preceeding to a specific group.
        ListNode groupPrev = dummy;
        while (true) {
            ListNode kth = getKth(groupPrev, k) ;
            // group of k does not exist.
            if (kth == null) {
                break;
            }
            // group of k does exist.
            ListNode groupNext = kth.next;

            ListNode prev = kth.next;
            ListNode curr = groupPrev.next;

            // This is same as reversal of a LL except that prev will nor point to null, but it will point to kth.next
            // Analogous to LL reversal , end will not correspond to null, but it will be groupNext in this case.
            
            while (curr != groupNext) {
                ListNode tmp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = tmp;
            }
            /**
             * Now will update the beginning and end pointers of the group which we just reversed. 
             */
            // lets store the first node of the group.
            ListNode tmp = groupPrev.next;

            // Must set the groupPrev's next pointer as the k th. 
            // same as putting k th. as beginning of the group.
            groupPrev.next  = kth;
            // for the next iteration, groupPrev will actually be set to the last node of the group now (which is groupPerv.next).
            groupPrev = tmp;

        }
        return dummy.next;

    }
    // helper method to get k th node.
        private ListNode getKth (ListNode curr, int k) {
            while (curr != null && k > 0) {
                curr = curr.next;
                k--;
            }
            return curr;
        }
}
