class Solution {
    public String makeLargestSpecial(String S) {
        int cnt = 0, i = 0;
        List<String> ret = new LinkedList<>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1')
                ++cnt;
            else
                --cnt;
            if (cnt == 0) {
                ret.add("1" + makeLargestSpecial(S.substring(i + 1, j)) + "0");
                i = j + 1;
            }
        }
        Collections.sort(ret, (s1, s2) -> s2.compareTo(s1));
        return String.join("", ret);
    }
}