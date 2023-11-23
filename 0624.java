import java.util.*;

class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int maxDist = 0;
        int minSoFar = arrays.get(0).get(0), maxSoFar = arrays.get(0).get(arrays.get(0).size() - 1);

        for (int i = 1; i < n; i++) {
            int currMin = arrays.get(i).get(0);
            int currMax = arrays.get(i).get(arrays.get(i).size() - 1);
            maxDist = Math.max(maxDist, maxSoFar - currMin);
            maxDist = Math.max(maxDist, currMax - minSoFar);
            minSoFar = Math.min(minSoFar, currMin);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxDist;

    }
}