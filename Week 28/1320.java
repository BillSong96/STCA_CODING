class Solution {
    public int minimumDistance(String word) {
        int[][] dp = new int[26][26];
        for (char c : word.toCharArray()) {
            int pos = (int) (c - 'A');
            int[][] temp = new int[26][26];
            for (int[] line : temp) Arrays.fill(line, Integer.MAX_VALUE);
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (dp[i][j] != Integer.MAX_VALUE) {
                        temp[pos][j] = Math.min(temp[pos][j], dp[i][j] + dis(i, pos));
                        temp[i][pos] = Math.min(temp[i][pos], dp[i][j] + dis(j, pos));
                    }
                }
            }
            dp = temp;
        }
        int ret = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                ret = Math.min(ret, dp[i][j]);
            }
        }
        return ret;
    }
    private int dis(int i, int j) {
        int iMod = (j + 1) % 6, jMod = (i + 1) % 6;
        if (iMod == 0) iMod += 6;
        if (jMod == 0) jMod += 6;
        return (int) Math.abs(iMod - jMod) + (int) Math.abs(j / 6 - i / 6);
    }
}