class Solution {
    public int partitionString(String s) {
        int[] seen = new int[26];
        int partitions = 1;
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (seen[s.charAt(i) - 'a'] == 1) {
                partitions++;
                seen = new int[26];
                seen[s.charAt(i) - 'a']++;
            } else {
                seen[s.charAt(i) - 'a']++;
            }
        }
        return partitions;
    }
}