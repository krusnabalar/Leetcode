import java.util.*;

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3)
            return s.length();
        int maxLen = 0;
        int left = 0, right = 0;
        Map<Character, Integer> charToFreq = new HashMap<>();
        while (right < s.length()) {
            charToFreq.put(s.charAt(right), charToFreq.getOrDefault(s.charAt(right++), 0) + 1);
            while (charToFreq.keySet().size() > 2) {
                int updateFreq = charToFreq.get(s.charAt(left)) - 1;
                if (updateFreq == 0) {
                    charToFreq.remove(s.charAt(left++));
                } else {
                    charToFreq.put(s.charAt(left++), updateFreq);
                }
            }
            maxLen = Math.max(right - left, maxLen);
        }

        return maxLen;
    }
}