import java.util.Arrays;

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int n = piles.length, m = n / 3, res = 0;
        for (int i = m; i < n; i += 2)
            res += piles[i];
        return res;
    }
}
