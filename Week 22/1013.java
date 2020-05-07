class Solution {
    public boolean canThreePartsEqualSum(int[] A) {
        int n = A.length, l = 0, r = n - 1, sum = 0;
        for (int num : A) {
            sum += num;
        }
        if (sum % 3 != 0) return false;
        sum /= 3;
        int temp = 0;
        for (; l < n; l++) {
            temp += A[l];
            if (temp == sum) break;
        }
        temp = 0;
        for (; r >= 0; r--) {
            temp += A[r];
            if (temp == sum) break;
        }
        return l + 1 < r;
    }
}