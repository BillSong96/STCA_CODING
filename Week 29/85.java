class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int n = matrix.length, m = matrix[0].length, ret = 0;
        int[] height = new int[m];
        for (int i = 0; i < n; i++) {
            Stack<Integer> st = new Stack<>();
            for (int j = 0; j <= m; j++) {
                if (j < m) height[j] = matrix[i][j] == '0' ? 0 : 1 + height[j];
                int h = j == m ? 0 : height[j];
                while (!st.isEmpty() && height[st.peek()] >= h) {
                    int cur = st.pop(), curH = height[cur], curW = j - 1 - (st.isEmpty() ? -1 : st.peek());
                    ret = Math.max(ret, curH * curW);
                }
                st.push(j);
            }
        }
        return ret;
    }
}