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
    public int goodNodes(TreeNode root) {
        // only the initial call to the heper method; "The starting point";
        return goodNodes(root, -99999999);
    }
    // Basically this is the DFS
    public int goodNodes(TreeNode curr, int max) {
        if (curr == null) {
            return 0;
        }
        int res;
        if (curr.val >= max) {
            res = 1; // Good Node so count that node
        } else {
            res = 0;
        }
        // The second argument is just the max value of node encountered in that path till now.
        res = res + (goodNodes(curr.left, Math.max(max, curr.val))); 
        res = res + (goodNodes(curr.right,Math.max(max, curr.val) ));
        return res;
    }
}
