package WeekCompetition.Week_258.InterchangeableRectangles;

import java.util.HashMap;

public class IPer {

    public long interchangeableRectangles(int[][] rectangles) {
        long result = 0;
        HashMap<Double, Long> map = new HashMap<>();
        for (int[] rectangle : rectangles) {
            // 把比值存入map，相同的+1
            map.merge(rectangle[0] * 1.0 / rectangle[1], 1L, Long::sum);
        }
        for (Long value : map.values()) {
            result += ((value - 1) * value) / 2; // (n-1)n / 2
        }
        return result;
    }
}
