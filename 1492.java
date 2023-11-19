class Solution {
    public int kthFactor(int n, int k) {
        int factor = 1;
        while (factor <= n) {
            while (factor < n && n % factor != 0) factor++;
            k--;
            if (k == 0) return factor;
            factor++;
        }
        return -1;
    }
}