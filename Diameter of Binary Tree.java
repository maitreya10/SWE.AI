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
    int result = -1;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;

    }
    private int dfs(TreeNode curr) {
        if (curr == null) {
            return -1;
        }
        // Calculate the height of left tree recursively.
        int left = 1 + dfs(curr.left);
        // calculate the height of the right recursively.
        int right = 1 + dfs(curr.right);
        // store the max value (diameter) till now in the instance variable.
        result = Math.max(result, left + right);
        // here we only need max BETWEEN left or right  as  dfs is called in RETURNING THE HEIGHT only the LEFT tree (or the right tree).
        return Math.max(left, right);
    }
}
