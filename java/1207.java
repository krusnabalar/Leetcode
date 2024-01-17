class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : arr) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        Set<Integer> frequencies = new HashSet<>();
        for (int freqVal : freq.values()) {
            if (!frequencies.add(freqVal)) {
                return false;
            }
        }
        return true;
    }
}