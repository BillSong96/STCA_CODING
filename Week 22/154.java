class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 2) return Math.min(nums[0], nums[1]);
        int pivotIndex = findPivot(nums, 0, nums.length - 1);
        if (pivotIndex <= 0) return nums[0];
        return Math.min(nums[0], nums[pivotIndex]);
    }
    
    private int findPivot(int[] nums, int l, int r) {
        int n = nums.length;
        if (r < 0 || l >= n || l + 1 >= r) return -1;
        int b = (l + r) / 2, a = b - 1, c = b + 1;
        if (nums[a] <= nums[b] && nums[b] > nums[c]) return c;
        if (nums[a] > nums[b] && nums[b] <= nums[c]) return b;
        return Math.max(findPivot(nums, l, b), findPivot(nums, b, r));
    }
}