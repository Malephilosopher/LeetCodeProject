package WeekCompetition.Week_278;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/30 10:31
 */
public class FindFinalValue {

    public int findFinalValue(int[] nums, int original) {
        int n = nums.length;
        while (true){
            boolean found = false;
            for (int i = 0; i < n; i++) {
                if(nums[i] == original){
                    original *= 2;
                    found = true;
                    break;
                }
            }
            if(!found) break;
        }
        return original;
    }
}
