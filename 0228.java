import java.util.*;

class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> response = new ArrayList<String>();
        int n = nums.length;
        if (n == 0)
            return response;
        StringBuilder range = new StringBuilder();
        range.append(Integer.toString(nums[0]));
        int startIdx = 0;

        for (int i = 0; i < n - 1; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                if (i - startIdx > 0) {
                    range.append("->" + nums[i]);
                }
                response.add(range.toString());
                startIdx = i + 1;
                range = new StringBuilder();
                range.append(nums[i + 1]);
            }
        }
        if (n - 1 - startIdx > 0) {
            range.append("->" + nums[n - 1]);
        }
        response.add(range.toString());

        return response;
    }
}