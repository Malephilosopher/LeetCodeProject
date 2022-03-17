package leetcode.greedy.Jump;

public class JOff {
    public int jump(int[] nums) {
        int n = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < n - 1; i++) {
            //每次更新从当前位置出发可以到达的最远位置
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if(i == end){
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
