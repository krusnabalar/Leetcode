import java.util.*;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> slidingWindowNumsSet = new HashSet<Integer>();
        int n = nums.length;
        if (k == 0)
            return false;

        for (int i = 0; i < n; i++) {
            if (i > k) {
                slidingWindowNumsSet.remove(nums[i - k - 1]);
            }
            if (slidingWindowNumsSet.contains(nums[i])) {
                return true;
            }

            slidingWindowNumsSet.add(nums[i]);
        }

        return false;
    }
}