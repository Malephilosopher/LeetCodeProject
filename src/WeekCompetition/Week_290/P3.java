package WeekCompetition.Week_290;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class P3 {

    public static int[] countRectangles(int[][] rectangles, int[][] points) {
        int n = points.length;
        int n1 = rectangles.length;
        int[] ans = new int[n];
        List<int[]> list1 = new ArrayList<>();
        for (int i = 0; i < n1; i++) {
            int[] rec = rectangles[i];
            list1.add(new int[]{rec[0], rec[1]});
        }

        list1.sort((o1, o2) -> {
            if(o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];

        });
        List<int[]> list2 = new ArrayList<>();
        int prel = 0, preh = 0;
        for (int i = 0; i < n1; i++) {
            int[] rec = list1.get(i);
            int li = rec[0];
            int hi = rec[1];
            if(li < prel || hi < preh){
                list1.remove(rec);
                i--;
                n1--;
                list2.add(rec);
                continue;
            }
            prel = li;
            preh = hi;
        }

        int i = 0;
        for (int[] point: points) {
            int xi = point[0];
            int yi = point[1];
            for (int j = 0; j < list1.size(); j++){
                int[] rec = list1.get(j);
                int li = rec[0];
                int hi = rec[1];
                if(li >= xi && hi >= yi){
                    ans[i] += list1.size() - j;
                    break;
                }
            }
            for (int j = 0; j < list2.size(); j++) {
                int[] rec = list2.get(j);
                int li = rec[0];
                int hi = rec[1];
                if(li >= xi && hi >= yi){
                    ans[i]++;
                }
            }
            i++;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(countRectangles(new int[][]{{7, 1}, {2, 6}, {1, 4}, {5,2},{10,3},{2,4},{5,9}}, new int[][]
                {{10,3},{8,10},{2,3},{5,4},{8,5},{7,10},{6,6},{3,6}})));
    }
}
