class Solution {
    public int[] findArray(int[] pref) {
        int n = pref.length;
        if (n == 1)
            return pref;

        for (int i = n - 1; i > 0; i--) {
            pref[i] ^= pref[i - 1];
        }
        return pref;
    }
}