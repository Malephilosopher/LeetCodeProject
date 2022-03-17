package leetcode.greedy.MaxSubArray;

public class MSAOff {

    public int maxSubArray(int[] nums) {
        //最大和
        int result = nums[0];
        //以前一项结尾的最大和
        int pre = 0;
        for (int num: nums) {
            //如果加上当前的更大，就加上当前的，否则从当前重新开始
            pre = Math.max(pre + num, num);
            result = Math.max(result, pre);
        }
        return result;
    }
}
