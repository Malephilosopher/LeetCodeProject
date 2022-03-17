package WeekCompetition.DoubleWeek72;

import java.util.ArrayList;
import java.util.List;

public class MaximumEvenSplit {

    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if(finalSum % 2 != 0) return ans;
        for (long i = 2, sum = 0; i <= finalSum; i += 2) {
            sum += i;
            ans.add(i);
            if(sum > finalSum) {
                ans.remove(sum - finalSum);
                break;
            }
        }
        return ans;
    }
}
