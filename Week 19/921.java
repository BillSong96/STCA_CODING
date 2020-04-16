class Solution {
    public int minAddToMakeValid(String S) {
        int ret = 0, lCount = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                lCount++;
            } else {
                if (lCount > 0) lCount--;
                else ret++;
            }
        }
        return ret + lCount;
    }
}