class Solution {
    public String findLongestWord(String s, List<String> d) {
        Collections.sort(d);
        String ret = "";
        int retLen = 0;
        for (String sub : d) {
            if (valid(s, sub)) {
                if (sub.length() > retLen) {
                    ret = sub;
                    retLen = sub.length();
                }
            }
        }
        return ret;
    }
    private boolean valid(String s, String sub) {
        int l1 = s.length(), l2 = sub.length(), is = 0, isub = 0;
        if (l1 < l2)
            return false;
        while (is < l1 && isub < l2)
            if (s.charAt(is++) == sub.charAt(isub))
                isub++;
        return isub == l2;
    }
}