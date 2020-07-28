class Solution {
    private static final int INVALID = -1, VALID = 0, END = 1;
    private static final Map<String, Integer> map = new HashMap<>();
    public boolean validTicTacToe(String[] board) {
        String key = String.join("", board);
        if (map.containsKey(key))
            return map.get(key) != INVALID;
        char[][] c = s2c(key);
        int xCnt = 0, oCnt = 0;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (c[i][j] == 'O') ++oCnt;
                else if (c[i][j] == 'X') ++xCnt;
            }
        }
        if (xCnt + oCnt == 0) {
            map.put(key, VALID);
            return true;
        }
        if (xCnt < oCnt || xCnt > oCnt + 1) {
            map.put(key, INVALID);
            return false;
        }
        char lastC = xCnt == oCnt ? 'O' : 'X';
        boolean end = (c[0][0] != ' ' && c[0][0] == c[0][1] && c[0][0] == c[0][2]) 
            || (c[1][0] != ' ' && c[1][0] == c[1][1] && c[1][0] == c[1][2]) 
            || (c[2][0] != ' ' && c[2][0] == c[2][1] && c[2][0] == c[2][2]) 
            || (c[0][0] != ' ' && c[0][0] == c[1][0] && c[0][0] == c[2][0]) 
            || (c[0][1] != ' ' && c[0][1] == c[1][1] && c[0][1] == c[2][1]) 
            || (c[0][2] != ' ' && c[0][2] == c[1][2] && c[0][2] == c[2][2]) 
            || (c[0][0] != ' ' && c[0][0] == c[1][1] && c[0][0] == c[2][2]) 
            || (c[0][2] != ' ' && c[0][2] == c[1][1] && c[0][2] == c[2][0]);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (c[i][j] == lastC) {
                    c[i][j] = ' ';
                    validTicTacToe(c2b(c));
                    int ret = map.get(c2s(c));
                    if (ret == VALID) {
                        map.put(key, end ? END : VALID);
                        return true;
                    }
                    c[i][j] = lastC;
                }
            }
        }
        map.put(key, INVALID);
        return false;
    }
    private String c2s(char[][] c) {
        StringBuilder sb = new StringBuilder();
        sb.append(new String(c[0]));
        sb.append(new String(c[1]));
        sb.append(new String(c[2]));
        return sb.toString();
    }
    private char[][] s2c(String s) {
        char[][] c = new char[3][3];
        for (int i = 0; i < 9; ++i) 
            c[i / 3][i % 3] = s.charAt(i);
        return c;
    }
    private String[] c2b(char[][] c) {
        return new String[] {new String(c[0]), new String(c[1]), new String(c[2])};
    }
}