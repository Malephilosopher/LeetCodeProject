package WeekCompetition.DoubleWeek_60.FindFarmland;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FFLPer {


    boolean[][] isVisited;

    public int[][] findFarmland(int[][] land) {
        int n = land.length;
        int m = land[0].length;
        isVisited = new boolean[n][m];
        List<int[]> ans = new ArrayList<>();
        for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < m; c1++) {
                if(isVisited[r1][c1] || land[r1][c1] == 0){
                    continue;
                }
                if(land[r1][c1] == 1){
                    int r2 = r1;
                    int c2 = c1;

                    while (r2 < n - 1 && land[r2 + 1][c2] == 1){
                        r2++;
                    }
                    while (c2 < m - 1 && land[r2][c2 + 1] == 1){
                        c2++;
                    }
                    paint(r1, c1, r2, c2);
                    int[] temp = {r1, c1, r2, c2};
                    ans.add(temp);
                }

            }
        }

        return ans.toArray(new int[ans.size()][4]);
    }

    public void paint(int r1, int c1, int r2, int c2) {
        for (int row = r1; row <= r2; row++) {
            for (int col = c1; col <= c2; col++) {
                isVisited[row][col] = true;
            }
        }
    }


    public static void main(String[] args) {
        int[][] land = {{1,0,0},{0,1,1},{0,1,1}};
        FFLPer fflPer = new FFLPer();
        System.out.println(Arrays.deepToString(fflPer.findFarmland(land)));
    }
}
