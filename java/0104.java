import util.TreeNode;

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return recursiveSearch(root, 0);
    }

    private int recursiveSearch(TreeNode root, int currMax) {
        if (root == null) return currMax;
        currMax++;
        return Math.max(recursiveSearch(root.left, currMax), recursiveSearch(root.right, currMax));
    }
}