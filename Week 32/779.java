class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 1)
            return 0;
        int k = (K + 1) / 2, i = (K + 1) & 1;
        if (kthGrammar(N - 1, k) == 1)
            return i == 0 ? 1 : 0;
        else 
            return i == 0 ? 0 : 1;
    }
}