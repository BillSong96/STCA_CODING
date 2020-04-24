class Solution {
    class Point {
        public int i, j, dis;
        public Point(int i, int j, int r0, int c0) {
            this.i = i;
            this.j = j;
            dis = (int) Math.abs(i - r0) + (int) Math.abs(j - c0);
        }
    }
    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                points.add(new Point(i, j, r0, c0));
            }
        }
        Collections.sort(points, (p1, p2)->Integer.compare(p1.dis, p2.dis));
        int[][] ret = new int[R * C][2];
        for (int i = 0; i < R * C; i++) {
            ret[i][0] = points.get(i).i;
            ret[i][1] = points.get(i).j;
        }
        return ret;
    }
}