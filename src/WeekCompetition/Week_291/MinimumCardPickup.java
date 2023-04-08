package WeekCompetition.Week_291;

import java.util.HashMap;
import java.util.Map;

public class MinimumCardPickup {

    public int minimumCardPickup(int[] cards) {
        int n = cards.length;

        Map<Integer, Integer> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            int num = cards[i];
            if(map.containsKey(num)){
                ans = Math.min(ans, i - map.get(num) + 1);
                found = true;
            }
            map.put(num, i);
        }
        if(!found)return -1;
        return ans;
    }
}
