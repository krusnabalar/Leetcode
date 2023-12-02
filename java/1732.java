class Solution {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int curr = 0;
        for (int altitudeChange : gain) {
            curr += altitudeChange;
            if (curr > max)
                max = curr;
        }
        return max;
    }
}