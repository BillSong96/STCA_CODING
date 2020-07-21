class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length, ret = 0, pre = 0, c, t;
        Map<Integer, Integer> count = new HashMap<>(){{put(0,1);}}, total = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pre ^= arr[i];
            c = count.getOrDefault(pre, 0);
            t = total.getOrDefault(pre, 0);
            ret += c * i - t;
            count.put(pre, c + 1);
            total.put(pre, t + i + 1);
        }
        return ret;
    }
}