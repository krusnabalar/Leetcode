class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, left = 0, right = 0, zeros = 0, n = nums.length;
        while (right < n) {
            if (nums[right] == 0)
                zeros++;
            while (zeros == 2) {
                if (nums[left] == 0)
                    zeros--;
                left++;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
}