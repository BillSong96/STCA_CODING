class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length < 2) return false;
        if (k == 0) {
            boolean flag = false;
            for (int num : nums) {
                if (num == 0) {
                    if (flag) return true;
                    flag = true;
                }
                else flag = false;
            }
            return false;
        }
        k = (int) Math.abs(k);
        Set<Integer> mods = new HashSet<>();
        int mod = 0, tempMod = 0;
        for (int num : nums) {
            mod = (mod + num) % k;
            if (mods.contains(mod)) return true;
            mods.add(tempMod);
            tempMod = mod;
        }
        return false;
    }
}
