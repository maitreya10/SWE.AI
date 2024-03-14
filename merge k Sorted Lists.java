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
    // Beats 100 % users in java (TIME COMPLEXITY)
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        // "inteval" is the interval between the indices of the 2 nodes which we will merge.
        int interval = 1; // **** must be 1 initially
        if (lists.length == 0) {
            return null;
        }
        while (interval < size) {
            for (int i = 0; i < size - interval; i = i + (2 * interval)) { // at one specific height of the merged tree, the range on nodes are "size - interval"
                lists[i] = merge(lists[i],  lists[i + interval]);
            }
            interval = interval * 2;
        }
        return lists[0];

    }
    /**
     * Helper method to merge two lists (by sorting the two lists)    
     */
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode curr = root;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if (l1 != null) {
                curr.next = l1;
        } else {
                curr.next = l2;
        }
        return root.next;

    }
}
