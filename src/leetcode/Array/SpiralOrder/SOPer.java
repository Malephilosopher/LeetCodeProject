package leetcode.Array.SpiralOrder;

import java.util.ArrayList;
import java.util.List;

public class SOPer {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix[0].length;
        int m = matrix.length;
        int i = 0, j = 0;
        boolean[][] visited = new boolean[m][n];
        List<Integer> ans = new ArrayList<>();
        int cur_step = 0;
        boolean right = true, down = false, left = false, up = false;
        while(cur_step < m * n)
        {
            if(right){
                if(check(i, j, m, n) && !visited[i][j])
                {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                    j++;
                }else {
                    j--;
                    i++;
                    right = false;
                    down = true;
                    continue;
                }
            }
            else if(down)
            {
                if(check(i, j, m, n) && !visited[i][j])
                {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                    i++;
                }else {
                    i--;
                    j--;
                    down = false;
                    left = true;
                    continue;
                }
            }
            else if(left)
            {
                if(check(i, j, m, n) && !visited[i][j])
                {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                    j--;
                }else {
                    j++;
                    i--;
                    left = false;
                    up = true;
                    continue;
                }
            }
            else if(up)
            {
                if(check(i, j, m, n) && !visited[i][j])
                {
                    ans.add(matrix[i][j]);
                    visited[i][j] = true;
                    i--;
                }else {
                    i++;
                    j++;
                    up = false;
                    right = true;
                    continue;
                }
            }
            cur_step++;
        }
        return ans;
    }
    private static boolean check(int i, int j, int m, int n)
    {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(spiralOrder(matrix));

    }
}
