class Solution {
    class Node {
        public Node zeroNext, oneNext;
        public Node() { zeroNext = null; oneNext = null; }
    }
    class Trie {
        private Node root;
        public int maxXOR;
        public Trie() {
            root = new Node();
            maxXOR = 0;
        }
        public void insert(int num) {
            Node cur = root;
            List<Node> list = new ArrayList<>();
            list.add(root);
            int result = 0;
            for (int d = 30; d >= 0; d--) {
                int digit = (num & (1 << d)) >> d;
                if (digit == 1) {
                    if (cur.oneNext == null) cur.oneNext = new Node();
                    cur = cur.oneNext;
                }
                else {
                    if (cur.zeroNext == null) cur.zeroNext = new Node();
                    cur = cur.zeroNext;
                }
                boolean flag = false;
                List<Node> temp = new ArrayList<>();
                for (Node node : list) {
                    if (digit == 1 && node.zeroNext != null || digit == 0 && node.oneNext != null) {
                        flag = true;
                        break;
                    }
                }
                if (flag) result += 1 << d;
                for (Node node : list) {
                    if (node.oneNext != null && (!flag || digit == 0)) temp.add(node.oneNext);
                    if (node.zeroNext != null && (!flag || digit == 1)) temp.add(node.zeroNext);
                }
                list = temp;
            }
            maxXOR = Math.max(maxXOR, result);
        }
    }
    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int num : nums) {
            trie.insert(num);
        }
        return trie.maxXOR;
    }
}