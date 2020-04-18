/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
class Solution {
    public NestedInteger deserialize(String s) {
        if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
        Stack<Object> st = new Stack<>();
        int numTemp = 0;
        boolean minus = false, isNum = false;
        for (char c : s.toCharArray()) {
            if (c == ',') {
                if (isNum) {
                    st.push(minus ? -numTemp : numTemp);
                    numTemp = 0;
                    minus = false;
                    isNum = false;
                }
            } else if (c == '[') {
                st.push(c);
            } else if (c == ']') {
                if (isNum) {
                    st.push(minus ? -numTemp : numTemp);
                    numTemp = 0;
                    minus = false;
                    isNum = false;
                }
                Stack<Object> objs = new Stack<>();
                while (!(st.peek() instanceof Character)) {
                    objs.push(st.pop());
                }
                st.pop();
                NestedInteger ni = new NestedInteger();
                while (!objs.isEmpty()) {
                    if (objs.peek() instanceof Integer) {
                        ni.add(new NestedInteger((Integer) objs.pop()));
                    } else {
                        ni.add((NestedInteger) objs.pop());
                    }
                }
                st.push(ni);
            } else {
                isNum = true;
                if (c == '-') minus = true;
                else numTemp = numTemp * 10 + (int) (c - '0');
            }
        }
        return (NestedInteger) st.pop();
    }
}