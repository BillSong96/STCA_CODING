class Solution {
    public int maximumGap(int[] nums) {
        int n = nums.length;
        if (n < 2) return 0;
        bucketSort(nums, 0, n - 1, 31);
        int ret = 0;
        for (int i = 1; i < n; i++)
            ret = Math.max(ret, nums[i] - nums[i - 1]);
        return ret;
    }
    private void bucketSort(int[] nums, int i, int j, int d) {
        if (i >= j || d < 0) return;
        int l = i, r = j;
        while (l < r) {
            int vl = (nums[l] >> d) & 1, vr = (nums[r] >> d) & 1;
            if (vl == 0 && vr == 1) {
                ++l;
                --r;
            }
            else if (vl == 1 && vr == 0) {
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                ++l;
                --r;
            }
            else if (vl == 0) {
                while (l < r && ((nums[l] >> d) & 1) == 0) l++;
                if (l < r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    ++l;
                    --r;
                }
            }
            else {
                while (l < r && ((nums[r] >> d) & 1) == 1) r--;
                if (l < r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    ++l;
                    --r;
                }
            }
        }
        if (l == r) {
            if (((nums[r] >> d) & 1) == 1) r--;
            else l++;
        }
        bucketSort(nums, i, r, d - 1);
        bucketSort(nums, l, j, d - 1);
    }
}