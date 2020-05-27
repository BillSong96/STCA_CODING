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
    private TreeNode ret;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ret;
    }
    private int dfs(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) return 0;
        int l = dfs(node.left, p, q), r = dfs(node.right, p, q);
        if ((node == p || node == q) && (l | r) != 0 || (l != 3 && r != 3 && (l | r) == 3)) ret = node;
        return (l | r) | (node == p ? 1 : (node == q ? 2 : 0));
    }
}