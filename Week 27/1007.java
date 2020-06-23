class Solution {
    public int minDominoRotations(int[] A, int[] B) {
        int num1 = A[0], num2 = B[0], c11 = 0, c12 = num1 == num2 ? 0 : 1, c21 = c12, c22 = 0;
        for (int i = 1; i < A.length; i++) {
            if (num1 != -1) {
                if (A[i] != num1 && B[i] != num1) num1 = -1;
                else {
                    c11 += A[i] == num1 ? 0 : 1;
                    c12 += B[i] == num1 ? 0 : 1;
                }
            }
            if (num2 != -1) {
                if (A[i] != num2 && B[i] != num2) num2 = -1;
                else {
                    c21 += A[i] == num2 ? 0 : 1;
                    c22 += B[i] == num2 ? 0 : 1;
                }
            }
        }
        int ret = -1;
        if (num1 != -1) {
            if (ret == -1 || ret > c11) ret = c11;
            if (ret == -1 || ret > c12) ret = c12;
        }
        if (num2 != -1) {
            if (ret == -1 || ret > c21) ret = c21;
            if (ret == -1 || ret > c22) ret = c22;
        }
        return ret;
    }
}