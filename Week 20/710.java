class Solution {
    
    private int realN;

    private Map<Integer, Integer> map = new HashMap<>();
    
    private Random rand = new Random();

    public Solution(int N, int[] blacklist) {
        List<Integer> preInList = new ArrayList<>();
        Set<Integer> blackSet = new HashSet<>();
        realN = N - blacklist.length;
        for (int blackNum : blacklist) {
            if (blackNum < realN) preInList.add(blackNum);
            else blackSet.add(blackNum);
        }
        int v = realN;
        for (Integer k : preInList) {
            while (blackSet.contains(v++));
            map.put(k, v - 1);
        }
    }
    
    public int pick() {
        int randNum = rand.nextInt(realN);
        return map.getOrDefault(randNum, randNum);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */