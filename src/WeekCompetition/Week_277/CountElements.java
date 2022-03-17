package WeekCompetition.Week_277;

import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/23 10:32
 */
public class CountElements {

    public int countElements(int[] nums) {
        int ans = 0;
        int n = nums.length;
        if(n <= 2) return 0;
        Arrays.sort(nums);
        for (int i = 1; i < n - 1; i++) {
            boolean flag1 = false;
            boolean flag2 = false;
            int j = i;
            while (true){
                if(nums[j] < nums[i]){
                    flag1 = true;
                    break;
                }else if(j == 0){
                    break;
                }else {
                    j--;
                }
            }
            j = i;
            while (true){
                if(nums[j] > nums[i]){
                    flag2 = true;
                    break;
                }else if(j == n - 1){
                    break;
                }else {
                    j++;
                }
            }
            if(flag1 && flag2){
                ans++;
            }
        }
        return ans;
    }
}
