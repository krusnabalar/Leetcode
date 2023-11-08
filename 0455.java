import java.util.*;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(s);
        Arrays.sort(g);

        int p1 = g.length - 1;
        int p2 = s.length - 1;

        while (p1 >= 0 && p2 >= 0) {
            if (s[p2] >= g[p1]) {
                p1--;
                p2--;
            } else {
                p1--;
            }
        }

        return s.length - p2 - 1;
    }
}