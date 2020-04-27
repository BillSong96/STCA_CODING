class Solution {
    private static int AND = (1 << 18) - 1;
    private static Map<Character, Integer> DNAMap = new HashMap<>(){{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};
    private static Map<Integer, Character> DNAMapReverse = new HashMap<>(){{
        put(0, 'A');
        put(1, 'C');
        put(2, 'G');
        put(3, 'T');
    }};
    
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ret = new ArrayList<>();
        int len = s.length();
        if (len <= 10) return ret;
        int num = 0;
        for (int i = 0; i < 10; i++) {
            num = (num << 2) + DNAMap.get(s.charAt(i));
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(num, 1);
        for (int i = 10; i < len; i++) {
            num = ((num & AND) << 2) + DNAMap.get(s.charAt(i));
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) ret.add(getStr(entry.getKey()));
        }
        return ret;
    }
    
    private String getStr(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(DNAMapReverse.get(num & 3));
            num >>= 2;
        }
        return sb.reverse().toString();
    }
}