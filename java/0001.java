import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> complementMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (complementMap.containsKey(target - nums[i])) {
                return new int[] { i, complementMap.get(target - nums[i]) };
            }
            complementMap.put(nums[i], i);
        }

        return null;
    }
}
