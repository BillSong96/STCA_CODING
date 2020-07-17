class Solution {
    public int hIndex(int[] cs) {
        int n = cs.length;
        int[] cnt = new int[n + 1];
        for (int c : cs) {
            if (c > n)
                ++cnt[n];
            else
                ++cnt[c];
        }
        int total = 0;
        for (int i = n; i >= 0; i--) {
            total += cnt[i];
            if (total >= i) return i;
        }
        return 0;
    }
}