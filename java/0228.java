import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> response = new ArrayList<String>();
        int n = nums.length;
        if (n == 0)
            return response;
        int start;
        for (int i = 0; i < n; i++) {
            start = nums[i];
            while (i + 1 < n && nums[i] + 1 == nums[i + 1])
                i++;
            response.add(start == nums[i] ? String.valueOf(start) : (start + "->" + nums[i]));
        }
        return response;
    }
}