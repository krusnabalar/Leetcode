import java.util.*;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xAxisValues = new int[points.length];
        int index = 0;
        for (int[] point : points) {
            xAxisValues[index] = point[0];
            index++;
        }
        Arrays.sort(xAxisValues);
        int maxWidth = 0;
        for (int i = 1; i < xAxisValues.length; i++) {
            if (xAxisValues[i] - xAxisValues[i - 1] > maxWidth) {
                maxWidth = xAxisValues[i] - xAxisValues[i - 1];
            }
        }
        return maxWidth;
    }
}
