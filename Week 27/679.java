class Solution {
    public boolean judgePoint24(int[] nums) {
        return judge(Arrays.stream(nums).asDoubleStream().toArray());
    }
    private boolean judge(double[] nums) {
        if (nums == null) return false;
        int n = nums.length;
        if (n == 0) return false;
        if (n == 1) return equals(nums[0], 24.0);
        boolean ret = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double[] temp = new double[n - 1];
                int index = 0;
                for (int k = 0; k < n; k++) {
                    if (k != i && k != j) temp[index++] = nums[k];
                }
                temp[index] = nums[i] + nums[j];
                ret |= judge(temp);
                temp[index] = nums[i] - nums[j];
                ret |= judge(temp);
                temp[index] = nums[j] - nums[i];
                ret |= judge(temp);
                temp[index] = nums[i] * nums[j];
                ret |= judge(temp);
                if (!equals(nums[j], 0.0)) {
                    temp[index] = nums[i] / nums[j];
                    ret |= judge(temp);
                }
                if (!equals(nums[i], 0.0)) {
                    temp[index] = nums[j] / nums[i];
                    ret |= judge(temp);
                }
            }
        }
        return ret;
    }
    private boolean equals(double d1, double d2) {
        return Math.abs(d1 - d2) < 0.0001;
    }
}