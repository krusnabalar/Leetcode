import java.util.*;

class Solution {
    public int countNicePairs(int[] nums) {
        int count = 0, MOD = (int) 1e9 + 7;
        Map<Integer, Integer> numRevDiffTally = new HashMap<>();

        for (int num : nums) {
            int numRevDiff = num - rev(num);
            count = (count + numRevDiffTally.getOrDefault(numRevDiff, 0)) % MOD;
            numRevDiffTally.put(numRevDiff, numRevDiffTally.getOrDefault(numRevDiff, 0) + 1);
        }

        return count;
    }

    private int rev(int num) {
        int res = 0;
        while (num > 0) {
            res = res * 10 + num % 10;
            num /= 10;
        }
        return res;
    }
}
