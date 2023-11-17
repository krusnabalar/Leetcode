import java.util.*;

class Solution {
    int n;
    List<String> ans;

    private void backtrack(String s, int leftCount, int rightCount) {
        if (s.length() == 2 * n) {
            ans.add(s);
            return;
        }
        if (leftCount < n)
            backtrack(s + "(", leftCount + 1, rightCount);
        if (leftCount > rightCount)
            backtrack(s + ")", leftCount, rightCount + 1);
    }

    public List<String> generateParenthesis(int n) {
        this.n = n;
        this.ans = new ArrayList<String>();
        backtrack("", 0, 0);
        return ans;
    }
}