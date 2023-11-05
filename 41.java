import java.util.*;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int[] tally = new int[n];
        Arrays.fill(tally, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0 && nums[i] <= n) {
                tally[nums[i] - 1] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (tally[i] == -1)
                return i + 1;
        }
        return n + 1;
    }
}