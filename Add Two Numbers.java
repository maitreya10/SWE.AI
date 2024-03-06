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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = 0;
        // carry over
        int c = 0;
        // One's place
        int o = 0;
        ListNode head = null;
        ListNode tmp = null;
        // we need to construct the answer node only as long as 3 conditions
        while (l1 != null || l2 != null || c > 0) {
            // Perform addition, record: carry and one's place.
            sum = c +
                (
                    ((l1 != null) ? l1.val : 0)
                    + ((l2 != null) ? l2.val : 0)
                );
            c = sum / 10;
            o = sum % 10;
            // Create New node and put one's place as value
            ListNode newNode = new ListNode(o);
            // Traverse to the end of the "Answer" LL where we need to insert the "newNode".
            if (head == null) {
                head = newNode;
            } else {
                tmp = head;
                while (tmp.next != null) {
                    tmp = tmp.next;
                }
                tmp.next = newNode;
                newNode.next = null;
            }
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            
        }
        return head;
    }
}
