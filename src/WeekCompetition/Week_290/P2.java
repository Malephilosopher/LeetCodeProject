package WeekCompetition.Week_290;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class P2 {

    public int countLatticePoints(int[][] circles) {
        boolean[][] visited = new boolean[210][210];
        int ans = 0;

        for (int[] circle: circles) {
            int xi = circle[0];
            int yi = circle[1];
            int r = circle[2];
            int startx = circle[0] - circle[2];
            int starty = circle[1] - circle[2];
            int endx = circle[0] + circle[2];
            int endy = circle[1] + circle[2];
            for (int i = startx; i <= endx; i++) {
                for (int j = starty; j <= endy; j++) {
                    if(visited[i][j])continue;
                    double distance = distance(i, j, xi, yi);
                    if(distance <= r * r){
                        ans++;
                        visited[i][j] = true;
                    }
                }
            }
        }
        return ans;
    }

    public double distance(int x1, int y1, int x2, int y2){
        return Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2);
    }


}
