class Solution {
    public String decodeAtIndex(String S, int K) {
        long n = 0;        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) n *= c - '0';
            else n++;
        }
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);
            if (Character.isDigit(c)) {
                n /= c - '0';
                K %= n;
            }
            else {
                if (K == 0 || K == n) return "" + c;
                n--;
            }
        }
        return "";
    }
}