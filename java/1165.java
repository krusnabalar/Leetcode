class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] idx = new int[26];
        for (int i = 0; i < 26; i++) {
            idx[keyboard.charAt(i) - 'a'] = i;
        }
        int res = 0, initIdx = 0;
        for (char c : word.toCharArray()) {
            res += Math.abs(idx[c - 'a'] - initIdx);
            initIdx = idx[c - 'a'];
        }
        return res;
    }
}