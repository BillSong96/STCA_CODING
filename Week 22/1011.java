class Solution {
    public int shipWithinDays(int[] weights, int D) {
        int sum = 0, n = weights.length;
        for (int weight : weights) {
            sum += weight;
        }
        int avg = (sum % D == 0) ? (sum / D) : (sum / D + 1);
        int l = avg, r = sum;
        while (l < r) {
            int m = (l + r) / 2;
            if (fun(weights, D, m)) r = m;
            else l = m + 1;
        }
        return l;
    }
    private boolean fun(int[] weights, int D, int sum) {
        int i = 0, n = weights.length;
        for (int d = 0; d < D && i < n; d++) {
            int dSum = 0;
            while (i < n) {
                if (dSum + weights[i] <= sum) {
                    dSum += weights[i++];
                    continue;
                }
                else break;
            }
        }
        return i == n;
    }
}