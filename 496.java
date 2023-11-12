import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        Map<Integer, Integer> nums2IndexHash = new HashMap<Integer, Integer>();

        for (int i = 0; i < m; i++) {
            nums2IndexHash.put(nums2[i], i);
        }

        int ind;
        for (int i = 0; i < n; i++) {
            ind = nums2IndexHash.get(nums1[i]);
            while (ind < m) {
                if (nums2[ind] > nums1[i]) {
                    ans[i] = nums2[ind];
                    break;
                }
                ind++;
            }
            if (ind == m)
                ans[i] = -1;
        }

        return ans;
    }
}