
class Solution {
    int maxPath = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathFinder(root);
        return maxPath;
    }

    private int maxPathFinder(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rootval = root.val;

        int leftPath = maxPathFinder(root.left);
        int rightPath = maxPathFinder(root.right);

        // Ignore negative contributions from children
        int left = Math.max(0, leftPath);
        int right = Math.max(0, rightPath);

        // Best complete path passing through this node
        int rootPath = rootval + left + right;

        maxPath = Math.max(maxPath, rootPath);

        // Return a path that can be extended by the parent.
        // We can only choose ONE child.
        return rootval + Math.max(left, right);
    }
}
