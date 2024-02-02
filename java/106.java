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
    int[] postorder;
    int idx;
    Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postorder = postorder;
        int n = inorder.length;
        this.idx = n - 1;
        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }
        return recurse(0, n - 1);
    }

    public TreeNode recurse(int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = postorder[idx];
        TreeNode root = new TreeNode(rootVal);
        idx--;
        root.right = recurse(map.get(rootVal) + 1, right);
        root.left = recurse(left, map.get(root.val) - 1);
        return root;
    }
}