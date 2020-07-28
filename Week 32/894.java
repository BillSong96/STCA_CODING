class Solution {
    private static final Map<Integer, List<TreeNode>> map = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N))
            return map.get(N);
        List<TreeNode> ret = new LinkedList<>();
        if ((N & 1) == 0)
            return ret;
        if (N == 1)
            ret.add(new TreeNode(0));
        else {
            for (int l = 1; l < N; l += 2) {
                List<TreeNode> retL = allPossibleFBT(l), retR = allPossibleFBT(N - l - 1);
                for (TreeNode rootL : retL) 
                    for (TreeNode rootR : retR) 
                        ret.add(new TreeNode(0, rootL, rootR));
            }
        }
        map.put(N, ret);
        return ret;
    }
}