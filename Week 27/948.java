class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        if (tokens.length == 0) return 0;
        int i = 0, j = tokens.length - 1, ret = 0;
        while (i < j) {
            if (P >= tokens[i]) {
                P -= tokens[i];
                ret++;
                i++;
            } else {
                if (ret == 0) return 0;
                P += tokens[j];
                ret--;
                j--;
            }
        }
        if (P >= tokens[i]) ret++;
        return ret;
    }
}