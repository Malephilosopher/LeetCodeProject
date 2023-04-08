package April.Day3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateMatrix {


    int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    boolean[][] visited;

    public int[][] generateMatrix(int n) {
        visited = new boolean[n][n];
        int[][] ans = new int[n][n];
        int i = 0, j = 0;
        int num = 1;
        ans[0][0] = num;
        visited[i][j] = true;
        while (num < n * n){
            for (int[] dir: dirs) {
                int nx = i + dir[0];
                int ny = j + dir[1];
                while (check(nx, ny, n)){
                    num++;
                    i = nx;
                    j = ny;
                    ans[i][j] = num;
                    visited[i][j] = true;
                    nx = i + dir[0];
                    ny = j + dir[1];
                }
            }
        }

        return ans;
    }

    public boolean check(int i, int j, int n){
        if(i < 0 || i >= n) return false;
        if(j < 0 || j >= n) return false;
        return !visited[i][j];
    }

    public static void main(String[] args) {
        GenerateMatrix s = new GenerateMatrix();
        System.out.println(Arrays.deepToString(s.generateMatrix(3)));
    }

}
