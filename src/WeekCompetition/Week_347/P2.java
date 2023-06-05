package WeekCompetition.Week_347;

import java.util.HashSet;
import java.util.Set;

public class P2 {

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] ans = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r = i, c = j;
                Set<Integer> set = new HashSet<>();
                while (r >= 0 && c >= 0){
                    int val = grid[r][c];
                    if(r != i && c != j) set.add(val);
                    r--;
                    c--;
                }

                int topLeft = set.size();
                set.clear();
                r = i;
                c = j;
                while (r < m && c < n){
                    int val = grid[r][c];
                    if(r != i && c != j) set.add(val);
                    r++;
                    c++;
                }
                int buttomRight = set.size();
                ans[i][j] = Math.abs(topLeft - buttomRight);
            }
        }

        return ans;

    }

    public static void main(String[] args) {

    }
}
