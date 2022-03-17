package WeekCompetition.Week_257.FirstDayBeenInAllRooms;

import java.util.HashMap;
import java.util.Map;

public class FDPer {

    private static final int MOD = 1000000007;


    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int day = -1;
        int n = nextVisit.length;
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, 0);
        }
        int i = 0;
        while (i < n){
            map.put(i, map.get(i) + 1);
            int count = map.get(i);
            if(count % 2 == 1){
                i = nextVisit[i];
            } else if(count % 2 == 0){
                i = (i + 1) % n;
            }
            day++;
            dp[i] = Math.max(dp[i], day);
        }


        return dp[n - 1];

    }

}
