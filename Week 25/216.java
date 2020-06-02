class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(k, n, new ArrayList<>(), ret);
        return ret;
    }
    private void dfs(int k, int n, List<Integer> list, List<List<Integer>> ret) {
        // System.out.println(k+" "+n+" "+list);
        if (k == 0) {
            if (n == 0) ret.add(list);
            return;
        }
        int small = list.size() == 0 ? 1 : list.get(list.size() - 1) + 1;
        if (9 * k < n || small * k > n) return;
        for (int num = small; num <= 9; num++) {
            if (n < num) break;
            List<Integer> cpy = new ArrayList<>();
            cpy.addAll(list);
            cpy.add(num);
            dfs(k - 1, n - num, cpy, ret);
        }
    }
}