package leetcode.greedy.EraseOverlapIntervals;

import java.util.Arrays;
import java.util.Comparator;

public class EOPer {

    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] intervals1, int[] intervals2) {
                if (intervals1[0] > intervals2[0]) {
                    return 1;
                } else if (intervals1[0] < intervals2[0]) {
                    return -1;
                } else {
                    return intervals1[1] - intervals2[1];
                }
            }
        });
        int ans = 0;
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] < intervals[i - 1][1]){
                ans++;
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return ans;
    }
}
