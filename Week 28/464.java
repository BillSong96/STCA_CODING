class Solution {
    public boolean canIWin(int max, int total) {
        if ((max + 1) * max / 2 < total) return false;
        if (total <= max) return true;
        Map<Integer, Boolean> map = new HashMap<>();
        int num = 0;
        for (int i = 1; i <= max; i++) num = add(num, i, max);
        return dfs(num, max, total, map);
    }
    private boolean valid(int num, int i, int n) {
        return (num >> (n - i)) % 2 != 0;
    }
    private int add(int num, int i, int n) {
        return num + (1 << (n - i));
    }
    private int remove(int num, int i, int n) {
        return num - (1 << (n - i));
    }
    private boolean dfs(int num, int max, int total, Map<Integer, Boolean> map) {
        if (map.containsKey(num)) return map.get(num);
        if (total <= 0) {
            map.put(num, false);
            return false;
        }
        boolean ret = false;
        for (int i = 1; i <= max; i++) {
            if (valid(num, i, max)) ret |= !dfs(remove(num, i, max), max, total - i, map);
        }
        map.put(num, ret);
        return ret;
    }
}