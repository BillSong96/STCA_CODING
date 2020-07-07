class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] ret = new int[n];
        int t = 0;
        Stack<Integer> st = new Stack<>();
        Set<Integer> set = new HashSet<>();
        for (String log : logs) {
            String[] arr = log.split(":");
            boolean isStart = arr[1].equals("start");
            int id = Integer.parseInt(arr[0]), cur = Integer.parseInt(arr[2]) + (isStart ? 0 : 1);
            while (!st.isEmpty() && set.contains(st.peek()))
                set.remove(st.pop());
            if (!st.isEmpty())
                ret[st.peek()] += cur - t;
            t = cur;
            if (isStart)
                st.push(id);
            else set.add(id);
        }
        return ret;
    }
}