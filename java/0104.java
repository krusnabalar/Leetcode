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