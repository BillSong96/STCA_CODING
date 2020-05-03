class Solution {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        while (num > 1) {
            if ((num & 3) != 0) return false;
            num >>= 2;
        }
        return true;
    }
}