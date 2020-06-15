class Solution {
    public String validIPAddress(String IP) {
        if (IP.length() == 0 || IP.charAt(0) == '.'|| IP.charAt(0) == ':'|| IP.charAt(IP.length() - 1) == '.'|| IP.charAt(IP.length() - 1) == ':') return "Neither";
        String[] v4s = IP.split("\\."), v6s = IP.split(":");
        return validV4(v4s) ? "IPv4" : (validV6(v6s) ? "IPv6" : "Neither");
    }
    private boolean validV4(String[] strs) {
        if (strs.length != 4) return false;
        for (String str : strs) {
            if (str.length() == 0 || str.length() > 4 || str.charAt(0) == '0' && str.length() != 1 || str.charAt(0) == '-') return false;
            try {
                int val = Integer.parseInt(str);
                if (val < 0 || val > 255) return false;
            } catch (Exception e) {
                return false;
            }
        }
        return true;
    }
    private boolean validV6(String[] strs) {
        if (strs.length != 8) return false;
        for (String str : strs) {
            if (str.length() == 0 || str.length() > 4) return false;
            for (char c : str.toCharArray()) {
                if (!(c >= '0' && c <= '9' || c >= 'a' && c <= 'f' || c >= 'A' && c <= 'F'))  return false;
            }
        }
        return true;
    }
}