class Solution {
    private Map<Integer, Integer> map = new HashMap<>();
    
    public int integerReplacement(int n) {
        if (n == 1) return 0;
        if (map.containsKey(n)) return map.get(n);
        int ret;
        if (n % 2 == 0) {
            ret = 1 + integerReplacement(n / 2);
        } else {
            ret = 2 + Math.min(integerReplacement((int) (((long) n + 1) / 2)), integerReplacement((n - 1) / 2));
        }
        map.put(n, ret);
        return ret;
    }
}