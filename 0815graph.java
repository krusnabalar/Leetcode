import java.util.*;

class Solution {
    List<List<Integer>> adjList = new ArrayList<>();

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;
        for (int i = 0; i < routes.length; i++) {
            Arrays.sort(routes[i]);
            adjList.add(new ArrayList<>());
        }

        createGraph(routes);

        Queue<Integer> q = new LinkedList<>();
        addStartingNodes(routes, source, q);

        Set<Integer> seen = new HashSet<Integer>(routes.length);
        int count = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int route = q.remove();
                for (int stop : routes[route])
                    if (stop == target)
                        return count;
                for (int nextRoute : adjList.get(route)) {
                    if (seen.add(nextRoute)) {
                        q.add(nextRoute);
                    }
                }
                size--;
            }
            count++;
        }

        return -1;
    }

    private void createGraph(int[][] routes) {
        for (int i = 0; i < routes.length; i++)
            for (int j = i + 1; j < routes.length; j++)
                if (haveCommonNode(routes[i], routes[j])) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
    }

    private boolean haveCommonNode(int[] route1, int[] route2) {
        int i = 0, j = 0;
        while (i < route1.length && j < route2.length) {
            if (route1[i] == route2[j]) {
                return true;
            } else if (route1[i] > route2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return false;
    }

    private void addStartingNodes(int[][] routes, int source, Queue<Integer> q) {
        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (stop == source) {
                    q.add(i);
                    break;
                }
            }
        }
    }
}