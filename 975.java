class Solution {
    public int oddEvenJumps(int[] A) {
        if (A == null) return 0;
        int len = A.length, ret = 1;
        if (len == 0) return 0;
        boolean[][] dp = new boolean[len][2]; // 0-odd, 1-even
        dp[len - 1][0] = dp[len - 1][1] = true;
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        treeMap.put(A[len - 1], len - 1);
        for (int i = len - 2; i >= 0; i--) {
            Integer ceil = treeMap.ceilingKey(A[i]), floor = treeMap.floorKey(A[i]);
            if (ceil != null) ret += (dp[i][0] = dp[treeMap.get(ceil)][1]) ? 1 : 0;
            if (floor != null) dp[i][1] = dp[treeMap.get(floor)][0];
            treeMap.put(A[i], i);
        }
        return ret;
    }
}