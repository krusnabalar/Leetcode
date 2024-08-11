import util.TreeNode;

class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        // BFS
        if (root == null) {
            return false;
        }
        int updatedTargetSum = targetSum - root.val;
        if (root.left == null && root.right == null) {
            return updatedTargetSum == 0;
        }
        return hasPathSum(root.left, updatedTargetSum) || hasPathSum(root.right, updatedTargetSum);
    }
}