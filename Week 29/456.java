class Solution {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int[] min = new int[n];
        min[0] = nums[0];
        for (int i = 1; i < n; i++)
            min[i] = Math.min(min[i - 1], nums[i]);
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int a = min[i], b = nums[i];
            if (a == b) continue;
            while (!st.isEmpty() && st.peek() <= b) {
                int c = st.pop();
                if (c == b) continue;
                if (c > a) return true;
            }
            st.push(b);
        }
        return false;
    }
}