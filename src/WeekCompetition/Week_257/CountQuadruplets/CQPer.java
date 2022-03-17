package WeekCompetition.Week_257.CountQuadruplets;

import java.util.*;

public class CQPer {

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    int s = nums[i] + nums[j] + nums[k];
                    int p = k + 1;
                    while(p <= n - 1){
                        if(nums[p] == s){
                            ans++;
                        }
                        if(p == n - 1){
                            break;
                        }
                        p++;
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {28,8,49,85,37,90,20,8};
        CQPer cqPer = new CQPer();
        System.out.println(cqPer.countQuadruplets(nums));
    }
}
