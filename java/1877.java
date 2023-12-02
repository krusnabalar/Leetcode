class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length, min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(num, max);
        }

        int[] tally = new int[max + 1];
        int res = 0;

        for (int i = 0; i < n; i++) {
            tally[nums[i]]++;
        }

        for (int lo = min, hi = max; lo <= hi;) {
            while (lo <= hi && tally[lo] == 0) {
                lo++;
            }
            while (hi >= lo && tally[hi] == 0) {
                hi--;
            }

            if (lo <= hi) {
                res = Math.max(res, lo + hi);
                tally[lo]--;
                tally[hi]--;
            }
        }

        return res;
    }
}