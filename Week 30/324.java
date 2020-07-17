class Solution {
    public void wiggleSort(int[] nums) {
        Arrays.sort(nums);
        final int len = nums.length;
        int mid = (len - 1) / 2, right = len - 1;
        int[] ret = new int[len];
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                ret[i] = nums[mid];
                mid--;
            }
            else {
                ret[i] = nums[right];
                right--;
            }
        }
        for (int i = 0; i < len; i++) {
            nums[i] = ret[i];
        }
    }
}