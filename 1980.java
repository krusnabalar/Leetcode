import java.util.*;

class Solution {
    Set<String> unique;
    int n;

    public String findDifferentBinaryString(String[] nums) {
        this.n = nums.length;
        this.unique = new HashSet<>(n);

        for (String s : nums)
            unique.add(s);

        return findAllBinaryStrings("");
    }

    private String findAllBinaryStrings(String s) {
        if (s.length() == n) {
            return !unique.contains(s) ? s : "";
        }

        String withZero = findAllBinaryStrings(s + "0");
        if (withZero.length() > 0) {
            return withZero;
        }

        return findAllBinaryStrings(s + "1");
    }
}