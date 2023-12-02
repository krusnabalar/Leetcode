import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int answer = 0;
        Arrays.sort(points, (a, b) -> (Integer.compare(a[1], b[1])));

        int i = 0;
        while (i < n) {
            int j = i + 1;
            while (j < n) {
                if (points[i][1] < points[j][0])
                    break;
                j++;
            }
            i = j;
            answer++;
        }
        return answer;
    }
}
