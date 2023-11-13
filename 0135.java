import java.util.*;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left2right = new int[n];
        int[] right2left = new int[n];
        Arrays.fill(left2right, 1);
        Arrays.fill(right2left, 1);

        // going from left to right, add candies for increasing ratings
        for (int i = 1; i < n; i++) {
            while (ratings[i] > ratings[i - 1] && left2right[i] <= left2right[i - 1]) {
                left2right[i]++;
            }
        }

        // going from left to right, add candies for increasing ratings
        for (int i = n - 2; i >= 0; i--) {
            while (ratings[i] > ratings[i + 1] && right2left[i] <= right2left[i + 1]) {
                right2left[i]++;
            }
        }

        int minCandies = 0;
        for (int i = 0; i < n; i++) {
            minCandies += Math.max(left2right[i], right2left[i]);
        }

        return minCandies;
        /*
         * [1,3,2,2,1] => 1,
         */
    }
}