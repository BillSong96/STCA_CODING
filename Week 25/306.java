class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        if (n < 3) return false;
        for (int i = 1; i < Math.min(n - 1, n / 2 + 1); i++) {
            String s1 = num.substring(0, i);
            if (s1.charAt(0) == '0' && s1.length() > 1) break;
            long l1 = Long.parseLong(s1);
            for (int j = i + 1; j < Math.min(n, n * 2 / 3 + 1); j++) {
                String s2 = num.substring(i, j);
                if (s2.charAt(0) == '0' && s2.length() > 1) break;
                long l2 = Long.parseLong(s2);
                if (dfs(num.substring(j), l1, l2)) return true;
            }
        }
        return false;
    }
    private boolean dfs(String s, long prePre, long pre) {
        // System.out.println(s+" "+prePre+" "+pre);
        long sum = prePre + pre;
        String sumStr = Long.toString(sum);
        if (s.equals(sumStr)) return true;
        if (!s.startsWith(sumStr)) return false;
        return dfs(s.substring(sumStr.length()), pre, sum);
    }
}