class Solution {    
    public int maxProduct(String[] words) {
        int len = words.length, ret = 0;
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = fun(words[i]);
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j && (nums[i] & nums[j]) == 0) {
                    ret = Math.max(ret, words[i].length() * words[j].length());
                }
            }
        }
        return ret;
    }
    
    private int fun(String word) {
        int ret = 0;
        for (char c : word.toCharArray()) {
            ret |= 1 << (int) (c - 'a');
        }
        return ret;
    }
}