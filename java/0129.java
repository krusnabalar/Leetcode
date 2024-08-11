import java.util.*;
import util.TreeNode;

class Solution {
    public int sumNumbers(TreeNode root) {
        // DFS
        int rootToLeaf = 0, currNum = 0;
        Deque<Pair> stack = new ArrayDeque<>();
        stack.push(new Pair(root, 0));

        while (!stack.isEmpty()) {
            Pair p = stack.pop();
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

class Pair {
    private TreeNode key;
    private Integer value;

    public Pair(TreeNode key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public TreeNode getKey() {
        return key;
    }

    public Integer getValue() {
        return value;
    }
}
