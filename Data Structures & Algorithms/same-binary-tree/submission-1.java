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
    boolean sameTree = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null || q == null){
            if(p != q){
                sameTree = false;
            }
            return sameTree;
        }
        isSameTree(p.left, q.left);
        isSameTree(p.right, q.right);

        if(p.val != q.val){
            sameTree = false;
        }
        return sameTree;
    }
}
