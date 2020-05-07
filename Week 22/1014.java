class Solution {
    public int maxScoreSightseeingPair(int[] A) {
        int n = A.length;
        int pre = A[0] - 1, ret = Integer.MIN_VALUE;
        for (int i = 1; i < n; i++) {
            ret = Math.max(ret, A[i] + pre);
            pre = Math.max(pre - 1, A[i] - 1);
        }
        return ret;
    }
}