class Solution {
    public int searchInsert(int[] nums, int target) {
        int res = 0;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) >>> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = res = mid + 1;
            } else {
                right = mid - 1;
                res = mid;
            }
        }

        return res;
    }
}