class Solution {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isUpperCase(c)) c = (char) ((int) c + 32);
            sb.append(c);
        }
        return sb.toString();
    }
}