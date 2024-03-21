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
class Solution {
    public boolean isValidBST(TreeNode root) {
      //if (root == null) return true;
      return isValidBST(root, null, null);  
    }
    private boolean isValidBST(TreeNode curr, Integer min, Integer max) {
        if (curr == null) return true;
        // min & max can be null so check that!
        if (min != null && curr.val <= min|| max != null && curr.val >= max) return false;

        return isValidBST(curr.left, min, curr.val) && isValidBST(curr.right, curr.val, max);
    }
}
