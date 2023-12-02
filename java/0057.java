import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int beginning = newInterval[0], end = newInterval[1];
        int beginningInterval = -1;
        List<int[]> answer = new ArrayList<>();
        int startOverlap = -1, endOverlap = -1;

        for (int i = 0; i < n; i++) {
            if (Math.min(end, intervals[i][1]) - Math.max(beginning, intervals[i][0]) >= 0) {
                if (startOverlap == -1) {
                    startOverlap = i;
                    endOverlap = i;
                } else {
                    endOverlap = i;
                }
            }
            if (beginningInterval == -1 && beginning < intervals[i][0]) {
                beginningInterval = i;
            }
        }

        if (startOverlap == -1) {
            boolean newIntervalInserted = false;
            for (int i = 0; i < n; i++) {
                if (!newIntervalInserted && beginningInterval == i) {
                    answer.add(newInterval);
                    i--;
                    newIntervalInserted = true;
                } else {
                    answer.add(intervals[i]);
                }
            }
            if (beginningInterval == -1) {
                answer.add(newInterval);
            }
            int[][] result = new int[answer.size()][2];
            int j = 0;
            for (int[] interval : answer) {
                if (j == beginningInterval) {
                    result[j] = newInterval;
                } else {
                    result[j] = interval;
                }
                j++;
            }
            return result;
        }

        for (int i = 0; i < n; i++) {
            if (i == startOverlap) {
                answer.add(new int[] { Math.min(intervals[startOverlap][0], beginning),
                        Math.max(intervals[endOverlap][1], end) });
                i = endOverlap;
            } else {
                answer.add(intervals[i]);
            }
        }
        int[][] result = new int[answer.size()][2];
        int j = 0;
        for (int[] interval : answer) {
            result[j] = interval;
            j++;
        }
        return result;
    }
}