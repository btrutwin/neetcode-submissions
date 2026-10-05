/**
 * * Definition for a binary tree node. * public class TreeNode { * int val; * TreeNode left; *
 * TreeNode right; * TreeNode() {} * TreeNode(int val) { this.val = val; } * TreeNode(int val,
 * TreeNode left, TreeNode right) { * this.val = val; * this.left = left; * this.right = right; * }
 * * }
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(root == null){
            return result;
        }
        q.add(root);
        while (q.isEmpty() == false) {
            int qLength = q.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < qLength; i++) {
                // check if the node we're poppings left/right are null. if not, then add to queue
                TreeNode pop = q.poll();
                if(pop.left != null){
                    q.add(pop.left);
                }
                if(pop.right != null){
                    q.add(pop.right);
                }
                level.add(pop.val);
            }
            result.add(level);
        }
        return result;
    }
}