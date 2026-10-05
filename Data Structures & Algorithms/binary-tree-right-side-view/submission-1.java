class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();

        if (root == null) {
            return result;
        }

        q.add(root);

        while (!q.isEmpty()) {
            int qLength = q.size();

            for (int i = 0; i < qLength; i++) {
                TreeNode node = q.poll();

                if (node.left != null) {
                    q.add(node.left);
                }

                if (node.right != null) {
                    q.add(node.right);
                }

                if (i == qLength - 1) {
                    result.add(node.val);
                }
            }
        }

        return result;
    }
}