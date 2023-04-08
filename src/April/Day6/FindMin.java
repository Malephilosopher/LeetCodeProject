package April.Day6;

import WeekCompetition.Week_277.MaximumGood;

import java.util.Arrays;

public class FindMin {

    public static int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        if(r == 0)return nums[0];
        while (l < r){
            int m = (l + r) >> 1;
            if(nums[m] < nums[r]){//如果右边有序
                r = m;
            }else {//如果右边无序，那么左边肯定有序
                l = m + 1;
            }
        }
        return nums[l];

    }

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{5,6,1,2,3,4}));
    }
}
