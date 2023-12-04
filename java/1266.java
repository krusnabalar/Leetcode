class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int n = points.length;
        int time = 0;
        int x0 = points[0][0], y0 = points[0][1];
        for (int i = 1; i < n; i++) {
            int x1 = points[i][0], y1 = points[i][1];
            time += Math.max(Math.abs(x1-x0), Math.abs(y1-y0));
            x0 = x1;
            y0 = y1;
        }
        return time;
    }
}