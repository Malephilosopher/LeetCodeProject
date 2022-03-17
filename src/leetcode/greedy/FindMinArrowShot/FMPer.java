package leetcode.greedy.FindMinArrowShot;

import java.util.Arrays;
import java.util.Comparator;

public class FMPer {

    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int ans = 1;
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == -2147483646){
                    return -1;
                }else if(o1[0] == 2147483646)
                {
                    return 1;
                }
                return o1[0] - o2[0];
            }
        });
        for (int i = 1; i < n; i++) {
            if(points[i][0] > points[i - 1][1]){
                ans++;
            }
            else {
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] points = {{-2147483646,-2147483645}, {2147483646,2147483647}};
        FMPer fmPer = new FMPer();
        System.out.println(fmPer.findMinArrowShots(points));
    }
}
