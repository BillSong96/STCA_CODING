class Solution {
    private int[] score, left;
    private int[][] dWords;
    private int n, ret;
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        n = words.length;
        this.score = new int[n];
        dWords = new int[n][26];
        for (int i = 0; i < n; ++i) {
            dWords[i] = fun(words[i].toCharArray());
            for (char c : words[i].toCharArray()) 
                this.score[i] += score[c - 'a'];
        }
        left = fun(letters);
        ret = 0;
        dfs(0, left, 0);
        return ret;
    }
    private int[] fun(char[] arr) {
        int[] ret = new int[26];
        for (char c : arr)
            ++ret[c - 'a'];
        return ret;
    }
    private void dfs(int i, int[] left, int curScore) {
        if (i == n) {
            ret = Math.max(ret, curScore);
            return;
        }
        dfs(i + 1, left, curScore);
        int[] temp = minus(left, dWords[i]);
        if (temp != null)
            dfs(i + 1, temp, curScore + score[i]);
    }
    private int[] minus(int[] arr1, int[] arr2) {
        int[] ret = new int[26];
        for (int i = 0; i < 26; ++i) {
            ret[i] = arr1[i] - arr2[i];
            if (ret[i] < 0)
                return null;
        }
        return ret;
    }
}