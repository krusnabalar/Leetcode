import java.util.*;

class Solution {
    public String removeVowels(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        for (int i = 0; i < n; i++)
            if (!vowels.contains(s.charAt(i)))
                sb.append(s.charAt(i));
        return sb.toString();
    }
}