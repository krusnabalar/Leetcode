class Solution {
    public char findTheDifference(String s, String t) {
        int[] tally = new int[26];
        for (char c : s.toCharArray()) {
            tally[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            tally[c - 'a']--;
            if (tally[c - 'a'] == -1) {
                return c;
            }
        }
        return 'a';
    }
}