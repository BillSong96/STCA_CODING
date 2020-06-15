class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        boolean[][] dp = new boolean[n][26];
        for (int i = 0; i < n; i++) {
            int ins = (int)(s.charAt(i) - 'a');
            if (i > 0) for (int j = 0; j < 26; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][ins] = !dp[i][ins];
        }
        List<Boolean> ret = new ArrayList<>();
        for (int[] q : queries) {
            ret.add((cnt(q[0] == 0 ? new boolean[26] : dp[q[0] - 1], dp[q[1]]) - (q[1] - q[0] + 1) % 2 + 1) / 2 <= q[2]);
        }
        return ret;
    }
    private int cnt(boolean[] b1, boolean[] b2) {
        int ret = 0;
        for (int i = 0; i < 26; i++) {
            ret += b1[i] == b2[i] ? 0 : 1;
        }
        return ret;
    }
}