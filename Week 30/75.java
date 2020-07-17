class Solution {
    public void sortColors(int[] nums) {
        int i = 0, l = i, j = nums.length - 1, r = j;
        while (i < j) {
            if (nums[i] == 0) {
                if (nums[j] == 2) {
                    nums[r--] = 2;
                    j--;
                }
                nums[l++] = 0;
                i++;
            }
            else if (nums[i] == 2) {
                if (nums[j] == 0) {
                    nums[l++] = 0;
                    nums[r--] = 2;
                    i++;
                }
                else if (nums[j] == 2) {
                    nums[r--] = 2;
                }
                j--;
            }
            else {
                if (nums[j] == 1) {
                    j--;
                }
                else if (nums[j] == 2) {
                    nums[r--] = 2;
                    j--;
                }
                i++;
            }
        }
        if (i == j) {
            if (nums[i] == 0)
                nums[l++] = 0;
            else if (nums[i] == 2)
                nums[r--] = 2;
        }
        while (l <= r)
            nums[l++] = 1;
    }
}