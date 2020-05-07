class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ret = 0;
        for (int num : nums) {
            if (num == Integer.MIN_VALUE || !set.contains(num - 1)) {
                int len = 0;
                while (set.contains(num)) {
                    len++;
                    if (num++ == Integer.MAX_VALUE) break;
                }
                ret = Math.max(ret, len);
            }
        }
        return ret;
    }
}