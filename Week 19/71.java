class Solution {
    public String simplifyPath(String path) {
        Deque<String> q = new ArrayDeque<>();
        for (String pathName : path.split("/")) {
            if (pathName.equals(".") || pathName.equals("")) continue;
            if (pathName.equals("..")) q.pollLast();
            else q.offerLast(pathName);
        }
        if (q.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            sb.append("/");
            sb.append(q.pollFirst());
        }
        return sb.toString();
    }
}