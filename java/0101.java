import util.TreeNode;

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