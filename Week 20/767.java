class Solution {
    public String reorganizeString(String S) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) 
            map.put(c, map.getOrDefault(c, 0) + 1);
        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (c1, c2)->{
            return -Integer.compare(map.get(c1), map.get(c2));
        });
        StringBuilder sb = new StringBuilder();
        while (list.size() > 1) {
            if (sb.length() != 0 && sb.charAt(sb.length() - 1) == list.get(0)) {
                char c = list.get(1);
                sb.append(c);
                if (map.get(c) == 1) list.remove(1);
                else {
                    map.put(c, map.get(c) - 1);
                    list.remove(1);
                    biInsert(list, c, map);
                }
            } else {
                char c = list.get(0);
                sb.append(c);
                if (map.get(c) == 1) list.remove(0);
                else {
                    map.put(c, map.get(c) - 1);
                    list.remove(0);
                    biInsert(list, c, map);
                }
            }
        }
        if (map.get(list.get(0)) > 1) return "";
        sb.append(list.get(0));
        return sb.toString();
    }
    private void biInsert(List<Character> list, char c, Map<Character, Integer> map) {
        int l = 0, r = list.size() - 1, cnt = map.get(c);
        while (l < r) {
            int m = (l + r) / 2;
            int mCnt = map.get(list.get(m));
            if (mCnt == cnt) {
                list.add(m, c);
                return;
            }
            if (mCnt > cnt) {
                l = m + 1;
                continue;
            }
            else r = m;
        }
        int lCnt = map.get(list.get(l));
        if (lCnt <= cnt) list.add(l, c);
        else if (l == list.size() - 1) list.add(c);
        else list.add(l + 1, c);
    }
}