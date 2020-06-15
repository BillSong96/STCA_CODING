class Solution {
    public List<String> removeSubfolders(String[] folder) {
        List<String> ret = new ArrayList<>();
        Arrays.sort(folder);
        String pre = null;
        for (String f : folder) {
            if (!isSub(pre, f)) {
                ret.add(f);
                pre = f;
            }
        }
        return ret;
    }
    private boolean isSub(String pre, String s) {
        return pre != null && s.length() > pre.length() && pre.equals(s.substring(0, pre.length())) && s.charAt(pre.length()) == '/';
    }
}