class Solution {
    int counter = 0;

    public int kthSmallest(TreeNode root, int k) {
        return traverse(root, k);
    }

    private int traverse(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }

        // 1. Search left
        int leftResult = traverse(root.left, k);

        // If left subtree found the answer, pass it back up
        if (leftResult != -1) {
            return leftResult;
        }

        // 2. Visit current node
        counter++;

        if (counter == k) {
            return root.val;
        }

        // 3. Search right
        return traverse(root.right, k);
    }
}