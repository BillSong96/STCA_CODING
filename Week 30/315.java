// Binary Search
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        if (n == 0) return new ArrayList<>();
        List<Integer> ret = new ArrayList<>(), list = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int index = insert(list, nums[i]);
            list.add(index, nums[i]);
            ret.add(index);
        }
        Collections.reverse(ret);
        return ret;
    }
    private int insert(List<Integer> list, int val) {
        if (list.isEmpty()) return 0;
        int l = 0, r = list.size() - 1;
        while (l < r) {
            if (list.get(l) >= val) return l;
            if (list.get(r) < val) return r + 1;
            int m = (l + r) / 2;
            if (list.get(m) < val) l = m + 1;
            else r = m;
        }
        return list.get(l) >= val ? l : l + 1;
    }
}

// Binary Search Tree
class Node {
    public int num, sum, dump;
    public Node left, right;
    public Node(int num, int sum) {
        this.num = num;
        this.sum = sum;
        this.dump = 1;
    }
}

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ret = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return ret;
        Node root = null;
        for (int i = n - 1; i >= 0; i--) {
            root = insert(nums[i], root, 0, ret);
        }
        Collections.reverse(ret);
        return ret;
    }
    private Node insert(int num, Node node, int preSum, List<Integer> list) {
        if (node == null) {
            list.add(preSum);
            node = new Node(num, 0);
        }
        else if (node.num == num) {
            list.add(preSum + node.sum);
            node.dump++;
        }
        else if (node.num > num) {
            node.sum++;
            node.left = insert(num, node.left, preSum, list);
        }
        else {
            node.right = insert(num, node.right, preSum + node.sum + node.dump, list);
        }
        return node;
    }
}

