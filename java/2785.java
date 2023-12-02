import java.util.*;

class Solution {
    public String sortVowels(String s) {
        int n = s.length();
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('A');
        vowels.add('e');
        vowels.add('E');
        vowels.add('E');
        vowels.add('i');
        vowels.add('I');
        vowels.add('o');
        vowels.add('O');
        vowels.add('u');
        vowels.add('U');

        int[] vowelArray = new int[n];
        int vowelCount = 0;
        for (int i = 0; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                vowelArray[i] = s.charAt(i);
                vowelCount++;
            }
        }

        Arrays.sort(vowelArray);

        int vowelArrayIndex = n - vowelCount;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (vowels.contains(s.charAt(i))) {
                ans.append((char) vowelArray[vowelArrayIndex]);
                vowelArrayIndex++;
            } else {
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
    }
}