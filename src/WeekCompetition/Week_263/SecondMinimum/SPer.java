package WeekCompetition.Week_263.SecondMinimum;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/17 11:20
 */
public class SPer {

    public int secondMinimum(int n, int[][] edges, int time, int change) {
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });

        int curPos = 1;
        int curTime = 0;
        int len = edges.length;
        while (curPos < n){
            boolean flag = false;
            for (int i = 0; i < len; i++) {
                if(edges[i][0] == curPos){
                    curPos = edges[i][1];
                }
            }

        }

        return 0;
    }

    public void dfs(int[] nums, int start){




//        for (int i = start; i < nums.length; i++) {
//            list.add(nums[i]);
//            dfs(nums, i + 1);
//            list.remove(list.size() - 1);
//        }

    }
}
