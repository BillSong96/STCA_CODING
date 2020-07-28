class Solution {
    public String countOfAtoms(String s) {
        Stack<TreeMap<String, Integer>> st = new Stack<>();
        st.push(new TreeMap<>());
        int i = 0, n = s.length();
        String pre = null;
        while (i < n) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                int v = 0;
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') 
                    v = 10 * v + (int) (s.charAt(i++) - '0');
                if (pre != null) {
                    st.peek().put(pre, st.peek().get(pre) + v - 1);
                    pre = null;
                }
                else {
                    TreeMap<String, Integer> base = st.pop(), multiply = new TreeMap<>();
                    for (Map.Entry<String, Integer> entry : base.entrySet())
                        multiply.put(entry.getKey(), v * entry.getValue());
                    st.push(multiply);
                }
            }
            else if (c == '(') {
                pre = null;
                st.push(getPar());
                st.push(new TreeMap<>());
                i++;
            }
            else if (c == ')') {
                pre = null;
                TreeMap<String, Integer> add = new TreeMap<>();
                while (!isPar(st.peek())) 
                    for (Map.Entry<String, Integer> entry : st.pop().entrySet()) 
                        add.put(entry.getKey(), add.getOrDefault(entry.getKey(), 0) + entry.getValue());
                st.pop();
                st.push(add);
                i++;
            }
            else {
                pre = s.substring(i, i++ + 1);
                while (i < n && s.charAt(i) >= 'a' && s.charAt(i) <= 'z')
                    pre += s.substring(i, i++ + 1);
                st.peek().put(pre, st.peek().getOrDefault(pre, 0) + 1);
            }
        }
        // System.out.println(st);
        TreeMap<String, Integer> sum = new TreeMap<>();
        while (!st.isEmpty()) 
            for (Map.Entry<String, Integer> entry : st.pop().entrySet()) 
                sum.put(entry.getKey(), sum.getOrDefault(entry.getKey(), 0) + entry.getValue());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sum.entrySet()) {
            sb.append(entry.getKey());
            if (entry.getValue() > 1)
                sb.append(Integer.toString(entry.getValue()));
        }
        return sb.toString();
    }
    private TreeMap<String, Integer> getPar() {
        TreeMap<String, Integer> ret = new TreeMap<>();
        ret.put(".", 0);
        return ret;
    }
    private boolean isPar(TreeMap<String, Integer> tm) {
        return tm.containsKey(".");
    }
}