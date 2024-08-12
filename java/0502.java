import java.util.PriorityQueue;

class Solution {
    public int findMaximizedCapital(int maxProjects, int currCapital, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<int[]> ascendingCapitalQueue = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> descendingProfitQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (int i = 0; i < n; i++) {
            ascendingCapitalQueue.add(new int[]{profits[i], capital[i]});
        }

        for (int i = 0; i < maxProjects; i++) {
            while (!ascendingCapitalQueue.isEmpty() && ascendingCapitalQueue.peek()[1] <= currCapital) {
                descendingProfitQueue.add(ascendingCapitalQueue.poll());
            }
            if (descendingProfitQueue.isEmpty()) {
                break;
            }
            currCapital += descendingProfitQueue.poll()[0];
        }
        return currCapital;
    }
}
