package WeekCompetition.Week_290;

import java.util.*;

public class P1 {

    public static List<Integer> intersection(int[][] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int[] arr : nums) {
            for (int x : arr) map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == n) list.add(entry.getKey());
        }
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        System.out.println(intersection(new int[][]{{3,1,2}, {4,5,6}}));
    }
}
