class Solution {
    public List<String> braceExpansionII(String s) {
        int n = s.length();
        if (n == 0) return new ArrayList<>();
        if (s.charAt(0) != '{') {
            List<String> temp = new ArrayList<>();
            temp.add(s.substring(0, 1));
            return cross(temp, braceExpansionII(s.substring(1)));
        }
        int d = 1, i = 1;
        while (true) {
            if (s.charAt(i) == '{') d++;
            if (s.charAt(i) == '}') d--;
            if (d == 0) break;
            i++;
        }
        if (i < n - 1) return cross(braceExpansionII(s.substring(0, i + 1)), braceExpansionII(s.substring(i + 1)));
        List<String> list = new ArrayList<>();
        int l = 1, r = 1;
        d = 1;
        while (r < n - 1) {
            if (s.charAt(r) == '{') {
                d++;
                r++;
            }
            else if (s.charAt(r) == '}') {
                d--;
                r++;
            }
            else if (s.charAt(r) == ',') {
                if (d == 1) {
                    list.add(s.substring(l, r));
                    l = r = r + 1;
                }
                else r++;
            }
            else {
                r++;
            }
        }
        if (l != r) list.add(s.substring(l, r));
        List<String> ret = braceExpansionII(list.get(0));
        for (i = 1; i < list.size(); i++) {
            ret = add(ret, braceExpansionII(list.get(i)));
        }
        return ret;
    }
    private List<String> cross(List<String> l1, List<String> l2) {
        if (l1.isEmpty()) return l2;
        if (l2.isEmpty()) return l1;
        Set<String> set = new HashSet<>();
        for (String s1 : l1) {
            for (String s2 : l2) {
                set.add(s1 + s2);
            }
        }
        return set.stream().sorted().collect(Collectors.toList());
    }
    private List<String> add(List<String> l1, List<String> l2) {
        l1.addAll(l2);
        return l1.stream().distinct().sorted().collect(Collectors.toList());
    }
}