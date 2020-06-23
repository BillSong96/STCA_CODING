class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        for (int h : hand) tm.put(h, tm.getOrDefault(h, 0) + 1);
        return fun(tm, W);
    }
    private boolean fun(TreeMap<Integer, Integer> tm, int W) {
        if (tm.isEmpty()) return true;
        int min = tm.ceilingKey(0);
        for (int i = min; i < min + W; i++) {
            if (!tm.containsKey(i)) return false;
            int cnt = tm.get(i);
            if (cnt == 1) tm.remove(i);
            else tm.put(i, cnt - 1);
        }
        return fun(tm, W);
    }
}