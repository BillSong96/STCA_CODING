class Solution {
    public char findTheDifference(String s, String t) {
        int[] sCount = new int[26], tCount = new int[26];
        for (char c : s.toCharArray()) {
            sCount[(int) (c - 'a')]++;
        }
        for (char c : t.toCharArray()) {
            tCount[(int) (c - 'a')]++;
        }
        for (int i = 0; i < 26; i++) {
            if (sCount[i] != tCount[i]) return (char) ((int) 'a' + i);
        }
        return 'a';
    }
}