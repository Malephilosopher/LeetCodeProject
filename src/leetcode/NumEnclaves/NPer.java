package leetcode.NumEnclaves;

public class NPer {

    int[][] dirs = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int m = 0;
    int n = 0;

    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            dfs(i, 0, grid);
            dfs(i, n - 1, grid);
        }
        for (int i = 1; i < n - 1; i++) {
            dfs(0, i, grid);
            dfs(m - 1, i, grid);
        }


        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if(grid[i][j] == 1){
                    ans++;
                }
            }
        }
        return ans;

    }

    public void dfs(int i, int j, int[][] grid){
        if(outOfBound(i, j, m, n) || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, grid);
        }
    }

    public boolean outOfBound(int x, int y, int m, int n){
        if(x < 0 || x >= m){
            return true;
        }
        return y < 0 || y >= n;
    }

}
