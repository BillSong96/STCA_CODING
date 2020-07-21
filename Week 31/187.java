class Solution {
    private static Map<Character, Long> code = new HashMap<>() {{
        put('A', 1l);
        put('C', 2l);
        put('G', 3l);
        put('T', 4l);
    }};
    private static Map<Long, Character> deCode = new HashMap<>() {{
        put(1l, 'A');
        put(2l, 'C');
        put(3l, 'G');
        put(4l, 'T');
    }};
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        long cur = 0;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (i < 10)
                cur = slide(cur, s.charAt(i), '\u0000');
            else
                cur = slide(cur, s.charAt(i), s.charAt(i - 10));
            if (i >= 9)
                map.put(cur, 1 + map.getOrDefault(cur, 0));
        }
        List<String> ret = new LinkedList<>();
        for (Map.Entry<Long, Integer> entry : map.entrySet())
            if (entry.getValue() >= 2)
                ret.add(decode(entry.getKey()));
        return ret;
    }
    private static long slide(long old, char add, char remove) {
        if (remove != '\u0000')
            old /= 10;
        long base = 1;
        while (base <= old)
            base *= 10;
        return old + base * code.get(add);
    }
    private String decode(long code) {
        StringBuilder sb = new StringBuilder();
        while (code > 0) {
            sb.append(deCode.get(code % 10));
            code /= 10;
        }
        return sb.toString();
    }
}