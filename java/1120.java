import util.TreeNode;

class Solution {
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null)
            return 0;

        double maxLeft = maximumAverageSubtree(root.left);
        double maxRight = maximumAverageSubtree(root.right);

        double sumLeft = sumNodes(root.left);
        int numLeft = numNodes(root.left);
        double sumRight = sumNodes(root.right);
        int numRight = numNodes(root.right);

        double avg = (root.val + sumRight + sumLeft) / (numRight + numLeft + 1);

        return Math.max(Math.max(avg, maxLeft), maxRight);
    }

    private double sumNodes(TreeNode root) {
        if (root == null)
            return 0;
        return root.val + sumNodes(root.left) + sumNodes(root.right);
    }

    private int numNodes(TreeNode root) {
        if (root == null)
            return 0;
        return 1 + numNodes(root.left) + numNodes(root.right);
    }
}