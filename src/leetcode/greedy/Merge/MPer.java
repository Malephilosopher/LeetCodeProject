package leetcode.greedy.Merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MPer {

    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1){
            return intervals;
        }
        //依据左边界排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        //用一个list暂存
        List<int[]> ans = new ArrayList<>();
        ans.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] <= ans.get(ans.size() - 1)[1]){
                //如果发现重叠
                ans.get(ans.size() - 1)[1] = Math.max(intervals[i][1],  ans.get(ans.size() - 1)[1]);
            }else {
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }

    public static void main(String[] args) {
        int[][] intervals = {{2,3},{2,2},{3,3},{1,3},{5,7},{2,2},{4,6}};
        MPer m = new MPer();
        System.out.println(Arrays.deepToString(m.merge(intervals)));
    }
}
