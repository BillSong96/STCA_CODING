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
    private int ret = 0;
    public int maxAncestorDiff(TreeNode root) {
        dfs(root.left, root.val, root.val);
        dfs(root.right, root.val, root.val);
        return ret;
    }
    private void dfs(TreeNode node, int preMax, int preMin) {
        if (node == null) return;
        ret = Math.max(ret, Math.max((int) Math.abs(preMax - node.val), (int) Math.abs(preMin - node.val)));
        preMax = Math.max(preMax, node.val);
        preMin = Math.min(preMin, node.val);
        dfs(node.left, preMax, preMin);
    }
}