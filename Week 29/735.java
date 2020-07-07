class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for (int v : asteroids) {
            if (v > 0) st.push(v);
            else {
                boolean flag = true;
                while (!st.isEmpty() && st.peek() > 0) {
                    if (st.peek() > -v) {
                        flag = false;
                        break;
                    }
                    if (st.peek() == -v) {
                        flag = false;
                        st.pop();
                        break;
                    }
                    st.pop();
                }
                if (flag) st.push(v);
            }
        }
        if (st.isEmpty()) return new int[]{};
        int[] ret = new int[st.size()];
        while (!st.isEmpty()) ret[st.size() - 1] = st.pop();
        return ret;
    }
}