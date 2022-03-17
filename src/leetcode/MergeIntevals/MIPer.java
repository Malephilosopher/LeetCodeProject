package leetcode.MergeIntevals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MIPer {
    public int[][] merge(int[][] intervals) {
        int l = intervals.length;
        List<Integer> left = new ArrayList<>(l);
        List<Integer> right = new ArrayList<>(l);
        for (int i = 0; i < l; i++) {
            left.add(i, intervals[i][0]);
            right.add(i, intervals[i][1]);
        }
        Comparator<Integer> c = Comparator.naturalOrder();
        left.sort(c);
        right.sort(c);
        int i = 0;
        while(i < l) {
            if (i < right.size() - 1) {
                if (right.get(i) >= left.get(i + 1)) {
                    right.set(i, (right.get(i + 1)));
                    left.remove(i + 1);
                    right.remove(i + 1);
                    l--;
                    continue;
                }
            }
            i++;
        }

        int[][] ans = new int[l][2];
        for ( i = 0; i < l; i++) {
            int[] in = new int[2];
            in[0] = left.get(i);
            in[1] = right.get(i);
            ans[i] = in;
        }


        return ans;
    }


    public static void main(String[] args) {

        int[][] a = {{1,4}, {0, 2}, {3, 5}};
        MIPer m = new MIPer();
        System.out.println(Arrays.deepToString(m.merge(a)));
    }
}
