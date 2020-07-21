class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ret = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (String w : words) {
            int val = fun(w);
            map.put(val, map.getOrDefault(val, 0) + 1);
        }
        for (String p : puzzles) {
            int cnt = 0, head = 1 << (p.charAt(0) - 'a'), val = fun(p), temp = val;
            while (temp > 0) {
                if ((temp & head) == head && map.containsKey(temp)) 
                    cnt += map.get(temp);             
                temp = (temp - 1) & val; 
            }
            ret.add(cnt);
        }
        return ret;
    }
    private int fun(String s) {
        int ret = 0;
        for (char c : s.toCharArray())
            ret |= 1 << (c - 'a');
        return ret;
    }
}