class Solution {
    private static final Map<Character, Long> primeMap = new HashMap<>(){{
        put('e', (long) 2);put('t', (long) 3);put('a', (long) 5);put('o', (long) 7);put('i', (long) 11);
        put('n', (long) 13);put('s', (long) 17);put('h', (long) 19);put('r', (long) 23);put('d', (long) 29);
        put('l', (long) 31);put('c', (long) 37);put('u', (long) 41);put('m', (long) 43);put('w', (long) 47);
        put('f', (long) 53);put('g', (long) 59);put('y', (long) 61);put('p', (long) 67);put('b', (long) 71);
        put('v', (long) 73);put('k', (long) 79);put('j', (long) 83);put('x', (long) 89);put('q', (long) 97);
        put('z', (long) 101);
    }};
    private Map<Long, Integer> map;
    public int minStickers(String[] stickers, String target) {
        map = new HashMap<>(){{ put((long) 1, 0); }};
        int n = stickers.length;
        int[][] stickersArr = new int[n][26];
        for (int i = 0; i < n; i++) {
            stickersArr[i] = getArr(stickers[i]);
        }
        return dfs(stickersArr, getLong(target));
    }
    private int dfs(int[][] stickers, long target) {
        if (map.containsKey(target)) return map.get(target);
        int ret = -1;
        for (int[] sticker : stickers) {
            long newTarget = cut(target, sticker);
            if (newTarget == target) continue;
            int temp = dfs(stickers, newTarget);
            if (temp != -1 && (ret == -1 || ret > temp)) ret = temp;
        }
        if (ret != -1) ret++;
        map.put(target, ret);
        return ret;
    }
    private int[] getArr(String str) {
        int[] ret = new int[26];
        for (char c : str.toCharArray()) {
            ret[(int) (c - 'a')]++;
        }
        return ret;
    }
    private long getLong(String str) {
        long ret = 1;
        for (char c : str.toCharArray()) {
            ret *= primeMap.get(c);
        }
        // System.out.println(ret);
        return ret;
    }
    private long cut(long target, int[] sticker) {
        for (int i = 0; i < 26; i++) {
            int temp = sticker[i];
            long div = primeMap.get((char) ('a' + i));
            while (temp > 0 && target % div == 0) {
                temp--;
                target /= div;
            }
        }
        return target;
    }
}