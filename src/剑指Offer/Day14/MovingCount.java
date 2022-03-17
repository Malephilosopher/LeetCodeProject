package 剑指Offer.Day14;

import 剑指Offer.Day11.ReverseWords;

public class MovingCount {

    int[][] dirs = {{1, 0}, {0, 1}};

    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        boolean[][] ok = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(numBitSum(i, j) > k){
                    ok[i][j] = false;
                }else {
                    ok[i][j] = true;
                }
            }
        }
        return dfs(ok, visited, 0, 0, m, n);
    }

    public int dfs(boolean[][] ok, boolean[][] visited, int x, int y, int m, int n){
        if( x >= m || y >= n || !ok[x][y] || visited[x][y]) return 0;

        int count = 1;
        visited[x][y] = true;
        for (int[] dir: dirs) {
            int x1 = x + dir[0];
            int y1 = y + dir[1];
            count += dfs(ok, visited, x1, y1, m, n);
        }
        return count;
    }

    public int numBitSum(int x, int y){
        int count = 0;
        while (x > 0){
            count += x % 10;
            x /= 10;
        }
        while (y > 0){
            count += y % 10;
            y /= 10;
        }
        return count;
    }

    public static void main(String[] args) {
        MovingCount r = new MovingCount();
        System.out.println(r.movingCount(2, 3, 1));
    }
}
