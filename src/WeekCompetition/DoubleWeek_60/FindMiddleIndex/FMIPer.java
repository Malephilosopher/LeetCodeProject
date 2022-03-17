package WeekCompetition.DoubleWeek_60.FindMiddleIndex;

import java.util.Arrays;

public class FMIPer {

    public int findMiddleIndex(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(cur == sum - cur - nums[i]){
                return i;
            }
            cur += nums[i];
        }
        return -1;
    }
}
