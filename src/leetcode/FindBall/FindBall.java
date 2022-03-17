package leetcode.FindBall;

public class FindBall {

    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int x = 0, y = i;
            boolean stuck = false;
            while (x < m && y >= 0 && y < n){
                int block = grid[x][y];
                if(block == 1 && (y == n - 1 || grid[x][y + 1]  == -1)){
                    stuck = true;
                    break;
                }else if(block == 1){
                    x++;
                    y++;
                }else if(block == -1 && (y == 0 || grid[x][y - 1]  == 1)){
                    stuck = true;
                    break;
                }else {
                    x++;
                    y--;
                }
            }
            if(stuck){
                ans[i] = -1;
            }else {
                ans[i] = y;
            }
        }
        return ans;

    }
}
