class Solution {
    public String[] spellchecker(String[] wordlist, String[] queries) {
        Set<String> set = new HashSet<>();
        Map<String, String> map = new HashMap<>(), mapCase = new HashMap<>();
        for (int i = wordlist.length - 1; i >= 0; i--) {
            String word = wordlist[i];
            set.add(word);
            mapCase.put(word.toLowerCase(), word);
            map.put(fun(word.toLowerCase()), word);
        }
        String[] ret = new String[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (set.contains(queries[i])) ret[i] = queries[i];
            else if (mapCase.containsKey(queries[i].toLowerCase())) ret[i] = mapCase.get(queries[i].toLowerCase());
            else ret[i] = map.getOrDefault(fun(queries[i].toLowerCase()), "");
        }
        return ret;
    }
    private String fun(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(isVower(c) ? '*' : c);
        }
        return sb.toString();
    }
    private boolean isVower(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}