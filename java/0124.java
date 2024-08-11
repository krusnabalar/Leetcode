import util.TreeNode;

class Solution {
    int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverseTree(root);
        return maxPathSum;
    }

    public int traverseTree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int[] pathSums = new int[2];
        pathSums[0] = Math.max(traverseTree(root.left), 0);
        pathSums[1] = Math.max(traverseTree(root.right), 0);

        maxPathSum = Math.max(maxPathSum, root.val + pathSums[0] + pathSums[1]);

        return Math.max(root.val + pathSums[0], root.val + pathSums[1]);
    }
}
