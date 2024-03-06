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
        if (head == null || head.next == null) {
            return null;
        }
        ListNode tmp = new ListNode();
        tmp.next = head;
        ListNode first = tmp;
        ListNode second = tmp;
        while (n > 0) {
            second = second.next;
            n--;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        // Important: "return head" misses out on a edge case
        // it Must be "return tmp.next""        
        return tmp.next;
    }
}
