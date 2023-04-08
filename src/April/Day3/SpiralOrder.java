package April.Day3;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    int m, n;
    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;

    public List<Integer> spiralOrder(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        int i = 0, j = 0;
        ans.add(matrix[0][0]);
        visited[i][j] = true;
        while (ans.size() < m * n){
            for (int[] dir: dirs) {
                int nx = i + dir[0];
                int ny = j + dir[1];
                while (check(nx, ny)){
                    ans.add(matrix[nx][ny]);
                    i = nx;
                    j = ny;
                    visited[i][j] = true;
                    nx = i + dir[0];
                    ny = j + dir[1];
                }
            }
        }

        return ans;
    }

    public boolean check(int i, int j){
        if(i < 0 || i >= m) return false;
        if(j < 0 || j >= n) return false;
        return !visited[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        SpiralOrder s = new SpiralOrder();
        System.out.println(s.spiralOrder(matrix));
    }
}
