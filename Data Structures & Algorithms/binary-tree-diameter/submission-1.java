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
    int maxDepth = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        nodeDepth(root);
        return maxDepth;
    }
    
    private int nodeDepth(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftDepth = nodeDepth(root.left);
        int rightDepth = nodeDepth(root.right);

        int nodeDiameter = leftDepth + rightDepth;
        if(nodeDiameter > maxDepth){
            maxDepth = nodeDiameter;
        }

        return 1 + Math.max(leftDepth, rightDepth);
    }
}
