class Solution {
    public int tallestBillboard(int[] rods) {
        int sum = 0;
        for (int num : rods) sum += num;
        sum /= 2;
        int[] dp = new int[sum + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int num : rods) {
            int[] temp = new int[sum + 1];
            for (int i = 0; i <= sum; i++) {
                int l = (int) Math.abs(i - num), r = i + num;
                temp[i] = dp[i];
                if (l <= sum && dp[l] != -1) {
                    int resL = num >= i ? dp[l] + l : dp[l];
                    temp[i] = temp[i] == -1 ? resL : Math.max(temp[i], resL);
                }
                if (r <= sum && dp[r] != -1)
                    temp[i] = temp[i] == -1 ? dp[r] + num : Math.max(temp[i], dp[r] + num);
            }
            dp = temp;
        }
        return dp[0];
    }
}