package leetcode.greedy.WiggleMaxLength;

public class WMLOff {
    public int wiggleMaxLength(int[] nums){
        if(nums.length <= 1) return nums.length;
        int preDiff = 0;
        int curDiff = 0;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            curDiff = nums[i] - nums[i - 1];
            //出现峰值
            if((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)){
                result++;
                preDiff = curDiff;
            }
        }
        return result;

    }
}
