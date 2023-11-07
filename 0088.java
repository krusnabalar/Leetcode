class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int pointer = n + m - 1;

        while (pointer >= 0) {
            if (n <= 0) break;

            if ((m > 0) && (nums1[m - 1] > nums2[n - 1])) {
                nums1[pointer] = nums1[m - 1];
                m--;
            }  else {
                nums1[pointer] = nums2[n - 1];
                n--;
            }
            pointer--;
        }

    }
}