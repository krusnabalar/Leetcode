import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, Set<Integer>> stopRoutes = new HashMap<Integer, Set<Integer>>();
        int n = routes.length;
        for (int i = 0; i < n; i++) {
            for (int stop : routes[i]) {
                Set<Integer> busRoute = stopRoutes.getOrDefault(stop, new HashSet<>());
                busRoute.add(i);
                stopRoutes.put(stop, busRoute);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seenRoutes = new HashSet<>(routes.length);
        for (int route : stopRoutes.get(source)) {
            q.add(route);
            seenRoutes.add(route);
        }

        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int currRoute = q.remove();
                for (int stop : routes[currRoute]) {
                    if (stop == target)
                        return count;
                    for (int route : stopRoutes.get(stop)) {
                        if (seenRoutes.add(route))
                            q.add(route);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}