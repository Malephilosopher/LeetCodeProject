package WeekCompetition.Week_286;

import java.util.ArrayList;
import java.util.List;

public class MinDeletion {

    public static int minDeletion(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i + 1 < n; i++) {
            if (nums[i] == nums[i + 1]) ans++;
            else i++;
        }
        if (((n - ans) & 1) == 1) ans++;
        return ans;
    }

    public int minDeletion1(int[] nums){
        int flag = 1, last = nums[0], ans = 0;
        for(int i = 1; i < nums.length; i++) {
            if(flag == 1) {          //此时前一位是偶数下标，需判断
                if(nums[i] == last) ans++;
                else flag = 0;
            }
            else {              //此时前一位是奇数下标，可直接加入
                flag = 1;
                last = nums[i];
            }
        }
        return (nums.length - ans) % 2 == 1 ? ans + 1 : ans;
    }



    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,2,2,3,3,3};

        System.out.println(minDeletion(nums));
    }
}
