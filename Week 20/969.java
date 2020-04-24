class Solution {
    public List<Integer> pancakeSort(int[] A) {
        return fun(A, A.length, A.length, new ArrayList<>());
    }
    private List<Integer> fun(int[] A, int len, int leftLen, List<Integer> list) {
        if (leftLen == 1) {
            list.add(len);
            return list;
        }
        int min = len - leftLen + 1;
        if (A[leftLen - 1] == min) return fun(A, len, leftLen - 1, list);
        int minI = -1;
        for (int i = 0; i < leftLen; i++) {
            if (A[i] == min) {
                minI = i;
                break;
            }
        }
        flip(A, minI + 1);
        list.add(minI + 1);
        flip(A, leftLen);
        list.add(leftLen);
        return fun(A, len, leftLen - 1, list);
    }
    private void flip(int[] A, int count) {
        for (int i = 0; i < count / 2; i++) {
            int temp = A[i];
            A[i] = A[count - i - 1];
            A[count - i - 1] = temp;
        }
    }
}