import java.util.*;

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
    int[] preorder;
    int n;
    int idx = 0;
    Map<Integer, Integer> inorderIdx;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        n = preorder.length;
        inorderIdx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            inorderIdx.put(inorder[i], i);
        }
        return recurse(0, n - 1);
    }

    public TreeNode recurse(int left, int right) {
        if (left > right || right >= n || idx >= n) {
            return null;
        }
        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);
        int i = inorderIdx.get(rootVal);
        root.left = recurse(left, i - 1);
        root.right = recurse(i + 1, right);

        return root;
    }
}