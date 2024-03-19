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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<Integer>(0);
        }
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);
        TreeNode curr = root;
        while (!queue.isEmpty()) {
            // It is very important to store the queue's size here itself.
            int len = queue.size();
            // *****( it should be "i < len" AND NOT "i < queue.size()" as queue.size() will change through the iteration.)
            for (int i = 0 ; i < len; i++) {
                // level.add(queue.poll)
                curr = queue.poll(); 
                if (i == 0) {
                    res.add(curr.val);
                }
                
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                if (curr.left != null) {
                    queue.add(curr.left);
                }   
            }
        }
        return res;
    }
}
