class Solution {
    private static final Map<Integer, Integer> map = new HashMap<>();
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        if (n > 10) return countNumbersWithUniqueDigits(10);
        if (map.containsKey(n)) return map.get(n);
        int ret = 9;
        for (int i = 1; i < n; i++) {
            ret *= 10 - i;
        }
        ret += countNumbersWithUniqueDigits(n - 1);
        map.put(n, ret);
        return ret;
    }
}