import java.util.*;

class Solution {
    public int[] getAverages(int[] nums, int k) {
        if (k == 0)
            return nums;

        int n = nums.length, diameter = (2 * k) + 1;
        int[] avg = new int[n];
        Arrays.fill(avg, -1);

        if (diameter > n)
            return avg;

        long rangeSum = 0;
        for (int i = 0; i < diameter; ++i) {
            rangeSum += nums[i];
        }
        avg[k] = (int) (rangeSum / diameter);

        for (int i = diameter; i < n; ++i) {
            rangeSum = rangeSum - nums[i - diameter] + nums[i];
            avg[i - k] = (int) (rangeSum / diameter);
        }

        return avg;
    }
}