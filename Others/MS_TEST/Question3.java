package Others.MS_TEST;

import java.util.*;

public class Question3 {

    class Path {
        public List<Integer> path;
        public Set<Integer> pathSet;
        public int sum;
        public Path() {
            path = new ArrayList<>();
            pathSet = new HashSet<>();
            sum = 0;
        }
    }

    private Path minPath = new Path();

    public Path shortestPath(String[] cities, int[][] paths) {
        int N = cities.length;
        Set<Integer>[] edges = new HashSet[N];
        for (int[] path : paths) {
            int city1 = path[0], city2 = path[1];
            Set<Integer> set = edges[city1] == null ? new HashSet<>() : edges[city1];
            set.add(city2);
            edges[city1] = set;
            set = edges[city2] == null ? new HashSet<>() : edges[city2];
            set.add(city1);
            edges[city2] = set;
        }
        Path path = new Path();
        path.path.add(0);
        path.pathSet.add(0);
        dfs(path, N, cities, edges);
        return minPath;
    }

    private void calculateSum(Path path, String[] cities) {
        int cityCount = path.path.size();
        int[] costs = new int[cityCount - 1];
        for (int i = 0; i < cityCount - 1; i++) {
            costs[i] = 1;
        }
        for (int i = 0; i < cityCount - 2; i++) {
            int city = path.path.get(i);
            if (cities[city].equals("Sand")) {
                costs[i] *= 2;
                costs[i + 1] *= 2;
            }
            if (cities[city].equals("Nitro")) {
                costs[i] /= 2;
                costs[i + 1] /= 2;
            }
            if (cities[city].equals("Crash")) {
                costs[i]++;
            }
        }
        if (cities[cityCount - 2].equals("Sand")) {
            costs[cityCount - 2] *= 2;
        }
        if (cities[cityCount - 2].equals("Nitro")) {
            costs[cityCount - 2] /= 2;
        }
        if (cities[cityCount - 2].equals("Crash")) {
            costs[cityCount - 2]++;
        }
        for (int cost : costs) {
            path.sum += cost;
        }
    }

    private void dfs(Path path, int N, String[] cities, Set<Integer>[] edges) {
        int lastCity = path.path.get(path.path.size() - 1);
        if (lastCity == N - 1) {
            calculateSum(path, cities);
            if (minPath.sum == 0 || path.sum < minPath.sum) minPath = path;
            return;
        }
        if (edges[lastCity] == null) return;
        for (Integer nextCity : edges[lastCity]) {
            if (path.pathSet.contains(nextCity) || cities[nextCity].equals("Cop")) continue;
            path.path.add(nextCity);
            path.pathSet.add(nextCity);
            dfs(path, N, cities, edges);
            path.path.remove(path.path.size() - 1);
            path.pathSet.remove(nextCity);
        }
    }
}