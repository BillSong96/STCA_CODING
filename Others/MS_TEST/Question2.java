package Others.MS_TEST;

import java.lang.Math;

public class Question2 {
    public int minShoots(int[] nums) {
        int N = nums.length;
        if (N < 2) return N;
        int[][] dp = new int[N][N];
        for (int d = 1; d <= N; d++) {
            for (int i = 0; i < N - d + 1; i++) {
                for (int j = i + d - 1; j < N; j++) {
                    if (d == 1) {
                        dp[i][j] = 1;
                        continue;
                    }
                    if (d == 2) {
                        dp[i][j] = nums[i] == nums[j] ? 1 : 2;
                        continue;
                    }
                    dp[i][j] = nums[i] == nums[j] ? dp[i + 1][j - 1] : j - i + 1;
                    for (int k = i; k < j; k++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
                    }
                }
            }
        }
        return dp[0][N - 1];
    }
}