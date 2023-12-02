import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        int max = 0, count = 1, n = nums.length;
        if (n == 0)
            return 0;
        Arrays.sort(nums);

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                count++;
            } else if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                max = Math.max(max, count);
                count = 1;
            }
        }

        return Math.max(max, count);
    }
}

/*
No sort solution:

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> uniqueNums = new HashSet<>();
        int max = 0;

        for (int num : nums) {
            uniqueNums.add(num);
        }
        for (int num : nums) {
            if (uniqueNums.contains(num - 1)) continue;
            int valueInSeq = num + 1;
            int count = 1;
            while (uniqueNums.contains(valueInSeq++)) {
                count++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
*/