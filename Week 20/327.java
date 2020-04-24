class Node {
    public long num;
    public int count, leftCount, rightCount;
    public Node left, right;
    public Node(long num) {
        this.num = num;
        this.count = 1;
    }
}

class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        if (n == 0) return 0;
        long[] sum = new long[n];
        sum[0] = (long) nums[0];
        for (int i = 1; i < n; i++)
            sum[i] = sum[i - 1] + (long) nums[i];
        Node root = null;
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] >= (long) lower && sum[i] <= (long) upper) ret++;
            ret += count(root, sum[i]- (long) upper, sum[i] - (long) lower);
            root = insert(root, sum[i]);
        }
        return ret;
    }
    private Node insert(Node node, long num) {
        if (node == null) node = new Node(num);
        else if (node.num == num) node.count++;
        else if (node.num > num) {
            node.leftCount++;
            node.left = insert(node.left, num);
        }
        else {
            node.rightCount++;
            node.right = insert(node.right, num);
        }
        return node;
    }
    private int count(Node root, long lower, long upper) {
        return root == null ? 0 : root.count + root.leftCount + root.rightCount - findLower(root, lower) - findUpper(root, upper);
    }
    private int findLower(Node node, long lower) {
        if (node == null) return 0;
        if (node.num == lower) return findLower(node.left, lower);
        if (node.num < lower) return node.count + findLower(node.left, lower) + findLower(node.right, lower);
        return findLower(node.left, lower);
    }
    private int findUpper(Node node, long upper) {
        if (node == null) return 0;
        if (node.num == upper) return findUpper(node.right, upper);
        if (node.num > upper) return node.count + findUpper(node.left, upper) + findUpper(node.right, upper);
        return findUpper(node.right, upper);
    }
}