package WeekCompetition.Week_282;

import java.util.HashMap;
import java.util.Map;

public class MinSteps {

    public int minSteps(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        int n1 = s.length();
        int n2 = t.length();
        for (int i = 0; i < n1; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n2; i++) {
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }

        int ans = 0;
        for (int value: map.values()) {
            ans += Math.abs(value);
        }
        return ans;

    }
}
