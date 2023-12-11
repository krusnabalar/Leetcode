class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1 || nums[0] < nums[nums.length - 1])
            return nums[0];
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[l]) {
                if (nums[mid] > nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            } else {
                if (nums[mid] < nums[r]) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
        }

        return nums[l];
    }
}
