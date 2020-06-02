class Solution {
    public int numTilePossibilities(String tiles) {
        List<Integer> counts = helper(tiles);
        return dfs(0, counts.size(), counts, 0, 1);
    }
    private int dfs(int i, int n, List<Integer> counts, int totalCount, int div) {
        if (i == n) {
            if (totalCount == 0) return 0;
            return factorial(totalCount) / div;
        }
        int ret = 0;
        int max = counts.get(i);
        for (int j = 0; j <= max; j++) {
            ret += dfs(i + 1, n, counts, totalCount + j, div * factorial(j));
        }
        return ret;
    }
    private List<Integer> helper(String tiles) {
        List<Integer> ret = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : tiles.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (Integer cnt : map.values()) {
            ret.add(cnt);
        }
        return ret;
    }
    private int factorial(int n) {
        int ret = 1;
        while (n > 1) ret *= n--;
        return ret;
    }
}