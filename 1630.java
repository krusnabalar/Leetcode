import java.util.*;

class Solution {
    int[] nums;

    private Boolean checkIfArithmetic(int l, int r) {
        int[] subarray = new int[r - l];
        for (int i = 0; i < r - l; i++) {
            subarray[i] = nums[i + l];
        }
        Arrays.sort(subarray);
        int diff = subarray[1] - subarray[0];
        for (int i = 1; i < r - l; i++) {
            if (subarray[i] - subarray[i - 1] != diff)
                return false;
        }
        return true;
    }

    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        this.nums = nums;
        int m = l.length;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int lIdx = l[i], rIdx = r[i] + 1;
            res.add(checkIfArithmetic(lIdx, rIdx));
        }
        return res;
    }
}