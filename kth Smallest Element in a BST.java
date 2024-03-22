/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 // The Iterative approach will involve a Stack.
 // This is the the recursive approach, It takes O(n) space as we need to create an array of n size at worst.
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        // Do inorder search.
        inorder(root, list);
        return list.get(k - 1);
        
    }
    // We will be doing the complete inorder and getting the complete Array. 
    // Then, our answer will the (k - 1)th index of the Array.
    private void inorder(TreeNode curr, List<Integer> list) {
        if (curr == null) {
            return;
        }
        inorder(curr.left, list);
        list.add(curr.val);
        inorder(curr.right, list);
    }
}
