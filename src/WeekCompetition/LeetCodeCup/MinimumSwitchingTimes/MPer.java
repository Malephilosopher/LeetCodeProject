package WeekCompetition.LeetCodeCup.MinimumSwitchingTimes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MPer {

    public int minimumSwitchingTimes(int[][] source, int[][] target) {
        int n = source.length;
        int m = source[0].length;
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> sou = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = source[i][j];
                if(map.containsKey(num)){
                    map.put(num, map.get(num) + 1);
                }else {
                    map.put(num, 1);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int num = target[i][j];
                if(map.containsKey(num)){
                    map.put(num, map.get(num) - 1);
                }else {
                    ans++;
                }
            }
        }

        for (int value: map.values()) {
            if(value < 0){
                ans += Math.abs(value);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] source = {{1, 3}, {5, 4}};
        int[][] target = {{3, 1}, {5, 5}};
        MPer m = new MPer();
        System.out.println(m.minimumSwitchingTimes(source, target));
    }
}
