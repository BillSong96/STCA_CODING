class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ret = new ArrayList<>();
        dfs(0, n, new ArrayList<>(), ret, initTemplate(n));
        return ret;
    }
    private List<String> initTemplate(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(j == i ? 'Q' : '.');
            }
            ret.add(sb.toString());
        }
        return ret;
    }
    private void dfs(int i, int n, List<Integer> pos, List<List<String>> ret, List<String> template) {
        if (i == n) {
            ret.add(helper(pos, template));
            return;
        }
        for (int j = 0; j < n; j++) {
            boolean flag = true;
            for (int preI = 0; preI < i; preI++) {
                int prePos = pos.get(preI);
                if (prePos == j || prePos == (j + preI - i) || prePos == (j + i - preI)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                pos.add(j);
                dfs(i + 1, n, pos, ret, template);
                pos.remove(i);
            }
        }
    }
    private List<String> helper(List<Integer> pos, List<String> template) {
        List<String> ret = new ArrayList<>();
        for (Integer i : pos) {
            ret.add(template.get(i));
        }
        return ret;
    }
}