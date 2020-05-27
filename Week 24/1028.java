/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class Node {
        public int val, step;
        public Node(int v, int s) {
            val = v;
            step = s;
        }
    }
    public TreeNode recoverFromPreorder(String S) {
        if (S.equals("")) return null;
        List<Node> list = helper(S.toCharArray());
        TreeNode root = new TreeNode(list.get(0).val);
        Map<Integer, TreeNode> map = new HashMap<>();
        map.put(0, root);
        int n = list.size();
        for (int i = 1; i < n; i++) {
            Node cur = list.get(i);
            TreeNode pre = map.get(cur.step - 1), curTN = new TreeNode(cur.val);
            if (pre.left == null) pre.left = curTN;
            else pre.right = curTN;
            map.put(cur.step, curTN);
        }
        return root;
    }
    private List<Node> helper(char[] s) {
        List<Node> list = new ArrayList<>();
        int n = s.length, i = 0;
        while (i < n) {
            int step = 0, val = 0;
            while (s[i] == '-') {
                step++;
                i++;
            }
            while (i < n && s[i] != '-') {
                val = val * 10 + (int) (s[i] - '0');
                i++;
            }
            list.add(new Node(val, step));
        }
        return list;
    }
}