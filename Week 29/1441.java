class Solution {
    private static final String push = "Push", pop = "Pop";
    public List<String> buildArray(int[] target, int n) {
        List<String> ret = new ArrayList<>();
        int j = 1;
        for (int i = 0; i < target.length; i++) {
            while (j < target[i]) {
                ret.add(push);
                ret.add(pop);
                j++;
            }
            ret.add(push);
            j++;
        }
        return ret;
    }
}