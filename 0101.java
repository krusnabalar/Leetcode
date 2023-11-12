/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root.left, root.right);
    }

    private Boolean isSameTree(TreeNode leftRoot, TreeNode rightRoot) {
        if (leftRoot == null ^ rightRoot == null)
            return false;
        if (leftRoot == null && rightRoot == null)
            return true;
        if (leftRoot.val != rightRoot.val)
            return false;
        return isSameTree(leftRoot.left, rightRoot.right) && (isSameTree(leftRoot.right, rightRoot.left));
    }
}