import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        if (n == 1) {
            return new ArrayList<>(Arrays.asList(new ArrayList<>(Arrays.asList(strs[0]))));
        }

        Map<String, List<String>> groupedAnagrams = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String s = sortString(strs[i]);
            if (!groupedAnagrams.containsKey(s)) {
                groupedAnagrams.put(s, new ArrayList<>());
            }
            groupedAnagrams.get(s).add(strs[i]);
        }

        return new ArrayList<>(groupedAnagrams.values());
    }

    private String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}