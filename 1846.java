import java.util.*;

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 1;
        Arrays.sort(arr);
        int res = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] >= res + 1)
                res++;
        }

        return res;
    }
}