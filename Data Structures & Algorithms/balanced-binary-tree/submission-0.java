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
    boolean treebalanced = true;
    public boolean isBalanced(TreeNode root) {
        nodeDepth(root);
        return treebalanced;
    }

    private int nodeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = nodeDepth(root.left);
        int rightDepth = nodeDepth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            treebalanced = false;
        }
        return 1 + Math.max(leftDepth, rightDepth);
    }
}
