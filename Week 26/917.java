class Solution {
    public String reverseOnlyLetters(String S) {
        char[] s = S.toCharArray();
        int i = 0, j = s.length - 1;
        while (true) {
            while (i < j &&
                   ((!Character.isLowerCase(s[i]) && !Character.isUpperCase(s[i])) ||
                    (!Character.isLowerCase(s[j]) && !Character.isUpperCase(s[j])))) {
                if (!Character.isLowerCase(s[i]) && !Character.isUpperCase(s[i])) i++;
                if (!Character.isLowerCase(s[j]) && !Character.isUpperCase(s[j])) j--;
            }
            if (i >= j) break;
            char temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
        return new String(s);
    }
}