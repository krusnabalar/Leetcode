import java.util.*;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int n = nums.length, max = -1, l = 0, r = n - 1;
        Arrays.sort(nums);
        while (l < r) {
            if (nums[l] + nums[r] >= k) {
                r--;
            } else {
                max = Math.max(max, nums[l] + nums[r]);
                l++;
            }
        }

        return max;
    }
}