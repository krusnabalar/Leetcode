
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

import java.util.*;

class Solution {
    public int sumNumbers(TreeNode root) {
        // DFS
        int rootToLeaf = 0, currNum = 0;
        Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> p = stack.pop();
            root = p.getKey();
            currNum = p.getValue();

            if (root != null) {
                currNum = (currNum * 10) + root.val;
                if (root.left == null && root.right == null) {
                    rootToLeaf += currNum;
                } else {
                    stack.push(new Pair(root.left, currNum));
                    stack.push(new Pair(root.right, currNum));
                }
            }
        }

        return rootToLeaf;
    }
}