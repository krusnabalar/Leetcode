import java.util.*;

class Solution {
    public int countPalindromicSubsequence(String s) {
        if (s.length() < 3)
            return 0;
        int res = 0;
        int n = s.length(), r = n - 1;
        Set<Character> countedMidChar = new HashSet<>();
        Set<Character> countedEndChars = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (countedEndChars.contains(s.charAt(i)))
                continue;
            while (i + 1 < r && s.charAt(r) != s.charAt(i))
                r--;
            if (s.charAt(i) == s.charAt(r)) {
                for (int j = i + 1; j < r; j++) {
                    if (countedMidChar.add(s.charAt(j))) {
                        countedEndChars.add(s.charAt(i));
                        res++;
                    }
                }
                countedMidChar.clear();
            }
            r = n - 1;
        }

        return res;
    }
}