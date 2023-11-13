import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int l, r, n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            if (i != 0 && nums[i - 1] == nums[i])
                continue;
            l = i + 1;
            r = n - 1;
            int offset = nums[i];
            while (l < r) {
                int sum = offset + nums[l] + nums[r];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[l++], nums[r]));
                    while (l < r && nums[l] == nums[l - 1])
                        l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return res;
    }
}