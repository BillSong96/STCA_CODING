class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if (k == n) return Arrays.stream(cardPoints).sum();
        int l = -1, r = n - 1, sum = 0;
        while (l < k - 1) sum += cardPoints[++l];
        int ret = sum;
        while (l >= 0) {
            sum += cardPoints[r--] - cardPoints[l--];
            ret = Math.max(ret, sum);
        }
        return ret;
    }
}