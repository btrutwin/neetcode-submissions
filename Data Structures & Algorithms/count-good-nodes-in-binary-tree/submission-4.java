
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
    int goodNodes = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        findGoodNodes(root, root.val);
        return goodNodes;
    }

    private void findGoodNodes(TreeNode root, int worstParent) {
        if (root == null) {
            return;
        }

        if (root.val >= worstParent) {
            goodNodes++;
            worstParent = root.val;
        }

        findGoodNodes(root.left, worstParent);
        findGoodNodes(root.right, worstParent);
    }
}
