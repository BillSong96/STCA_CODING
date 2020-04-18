class Solution {
    public int calPoints(String[] ops) {
        Stack<Integer> st = new Stack<>();
        for (String op : ops) {
            if (op.equals("+")) {
                Integer preScore = st.pop();
                Integer newScore = preScore + st.peek();
                st.push(preScore);
                st.push(newScore);
            } else if (op.equals("C")) {
                st.pop();
            } else if (op.equals("D")) {
                st.push(st.peek() * 2);
            } else {
                st.push(Integer.parseInt(op));
            }
        }
        int ret = 0;
        while (!st.isEmpty()) {
            ret += st.pop();
        }
        return ret;
    }
}