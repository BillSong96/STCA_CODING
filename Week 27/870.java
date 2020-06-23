class Solution {
    class N {
        public int val, inx;
        public N(int v, int i) {
            val = v;
            inx = i;
        }
    }
    public int[] advantageCount(int[] A, int[] B) {
        int n = A.length;
        N[] bn = new N[n];
        for (int i = 0; i < n; i++) {
            bn[i] = new N(B[i], i);
        }
        Arrays.sort(bn, (n1, n2) -> n1.val - n2.val);
        Arrays.sort(A);
        int l = 0, r = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            B[bn[i].inx] = A[r] > bn[i].val ? A[r--] : A[l++];
        }
        return B;
    }
}