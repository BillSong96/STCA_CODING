/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        Integer[] ret = dfs(root);
        return ret != null && (ret[0] == null || ret[0] <= root.val && root.val <= ret[1]);
    }
    private Integer[] dfs(TreeNode node) {
        Integer[] ret = new Integer[2];
        if (node == null) return ret;
        Integer[] l = dfs(node.left), r = dfs(node.right);
        if (l == null || r == null) return null;
        ret[0] = node.val;
        ret[1] = node.val;
        if (l[0] != null) {
            if (l[1] >= ret[0]) return null;
            ret[0] = l[0];
        }
        if (r[0] != null) {
            if (r[0] <= ret[1]) return null;
            ret[1] = r[1];
        }
        return ret;
    }
}