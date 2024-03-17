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
class Solution { // TC: O(n) SC: O(n)
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        // Important: Queue hold TreeNodes!
        Queue<TreeNode> queue = new LinkedList<>();

        if (root == null) {
            return res;
        }

        //lets add root first.
        queue.add(root);
        while (!queue.isEmpty()) {
            // you only need to add as many elements in that sublist
            int len = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i =0 ; i < len; i++) {
                // need to add from tree, so lets get a pointer.
                TreeNode curr = queue.poll();
                level.add(curr.val);
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            res.add(level);
        }
        return res;
    }
}
