package leetcode.greedy.FindMinArrowShot;

import java.util.Arrays;
import java.util.Comparator;

public class FMOff {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (point1, point2) -> {
            if (point1[1] > point2[1]) {
                return 1;
            } else if (point1[1] < point2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        int pos = points[0][1];
        int ans = 1;
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++ans;
            }
        }
        return ans;
    }

}
