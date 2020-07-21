class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length, ret = nums[0], cnt = 1;
        for (int i = 1; i < n; ++i) {
            if ((ret ^ nums[i]) == 0)
                cnt++;
            else if (cnt == 0) {
                ret = nums[i];
                cnt = 1;
            }
            else --cnt;
        }
        return ret;
    }
}