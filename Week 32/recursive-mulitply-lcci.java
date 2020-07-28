class Solution {
    public int multiply(int A, int B) {
        return A < B ? multiply(B, A) : (B == 0 ? 0 : (B == 1 ? A : multiply(A << 1, B >> 1) + ((B & 1) == 0 ? 0 : A)));
    }
}