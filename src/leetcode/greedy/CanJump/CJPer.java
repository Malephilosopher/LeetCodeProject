package leetcode.greedy.CanJump;

public class CJPer {

    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cover = 0;
        if(nums.length == 1) return true;
        for (int i = 0; i <= cover; i++) {
            cover = Math.max(i + nums[i], cover);
            if(cover >= n - 1){
                return true;
            }
        }
        return false;
    }
}
