class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(0, currSum) + num;
            maxSoFar = Math.max(maxSoFar, currSum);
        }

        return maxSoFar;
    }
}
