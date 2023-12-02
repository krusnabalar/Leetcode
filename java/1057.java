import java.util.*;

class Solution {
    class WorkerBikeTuple {
        int workerIdx;
        int bikeIdx;
        int distance;

        WorkerBikeTuple(int workerIdx, int bikeIdx, int distance) {
            this.workerIdx = workerIdx;
            this.bikeIdx = bikeIdx;
            this.distance = distance;
        }
    }

    Comparator<WorkerBikeTuple> WorkerBikePairComparator = new Comparator<WorkerBikeTuple>() {
        @Override
        public int compare(WorkerBikeTuple a, WorkerBikeTuple b) {
            if (a.distance != b.distance) {
                return a.distance - b.distance;
            } else if (a.workerIdx != b.workerIdx) {
                return a.workerIdx - b.workerIdx;
            } else {
                return a.bikeIdx - b.bikeIdx;
            }
        }
    };

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int n = workers.length, m = bikes.length;
        int[] ans = new int[n];
        int[] bikeStatus = new int[m];
        Arrays.fill(ans, -1);
        Arrays.fill(bikeStatus, -1);

        List<WorkerBikeTuple> allTriplets = new ArrayList<>();
        for (int bike = 0; bike < m; bike++) {
            for (int worker = 0; worker < n; worker++) {
                allTriplets.add(new WorkerBikeTuple(worker, bike, manhattanDist(workers[worker], bikes[bike])));
            }
        }

        Collections.sort(allTriplets, WorkerBikePairComparator);
        int count = 0;
        for (WorkerBikeTuple wbt : allTriplets) {
            if (ans[wbt.workerIdx] == -1 && bikeStatus[wbt.bikeIdx] == -1) {
                ans[wbt.workerIdx] = wbt.bikeIdx;
                bikeStatus[wbt.bikeIdx]++;
                count++;
                if (count == n)
                    break;
            }
        }

        return ans;
    }

    private int manhattanDist(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}