class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int n = s.length(), ret = 0;
        Map<String, Integer> map = new HashMap<>();
        for (int size = minSize; size <= maxSize; ++size) {
            Map<Character, Integer> cur = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char add = s.charAt(i);
                cur.put(add, 1 + cur.getOrDefault(add, 0));
                if (i == size - 1 && cur.size() <= maxLetters)
                    map.put(s.substring(0, size), 1);
                if (i >= size) {
                    char del = s.charAt(i - size);
                    int delCnt = cur.get(del);
                    if (delCnt == 1)
                        cur.remove(del);
                    else
                        cur.put(del, delCnt - 1);
                    if (cur.size() <= maxLetters) {
                        String k = s.substring(i - size + 1, i + 1);
                        map.put(k, 1 + map.getOrDefault(k, 0));
                    }
                }
            }
        }
        for (Map.Entry<String, Integer> entry : map.entrySet())
            ret = Math.max(ret, entry.getValue());
        return ret;
    }
}