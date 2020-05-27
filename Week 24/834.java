class Solution {
    class Node {
        public int val;
        public List<Node> next;
        public Node(int val) {
            this.val = val;
            next = new ArrayList<>();
        }
    }
    private int[] count, ret;
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        count = new int[N];
        ret = new int[N];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] e : edges) {
            int i = e[0], j = e[1];
            List<Integer> list1 = map.getOrDefault(i, new ArrayList<>());
            list1.add(j);
            map.put(i, list1);
            List<Integer> list2 = map.getOrDefault(j, new ArrayList<>());
            list2.add(i);
            map.put(j, list2);
        }
        Node root = new Node(0);
        preOrder(map, new HashSet<>(), root);
        postOrder(map, new HashSet<>(), root);
        return ret;
    }
    private void preOrder(Map<Integer, List<Integer>> map, Set<Integer> set, Node node) {
        set.add(node.val);
        List<Integer> list = map.get(node.val);
        count[node.val]++;
        if (list == null) return;
        for (Integer j : list) {
            if (set.contains(j)) continue;
            Node next = new Node(j);
            node.next.add(next);
            preOrder(map, set, next);
            count[node.val] += count[next.val];
            ret[0] += count[next.val];
        }
    }
    private void postOrder(Map<Integer, List<Integer>> map, Set<Integer> set, Node node) {
        set.add(node.val);
        for (Node next : node.next) {
            if (set.contains(next.val)) continue;
            ret[next.val] = ret[node.val] - 2 * count[next.val] + ret.length;
            postOrder(map, set, next);
        }
    }
}