package leetcode.greedy.CanCompleteCircuit;

public class CCCPer {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int[] rest = new int[n];
        for (int i = 0; i < n; i++) {
            rest[i] = gas[i] - cost[i];
        }
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            curSum += rest[i];  // 当前累加rest[i]和 curSum一旦小于0
            totalSum += rest[i];
            if(curSum < 0){     // 起始位置更新为i+1
                start = i + 1;  // curSum从0开始
                curSum = 0;
            }
        }
        if(totalSum < 0) return -1;// 说明怎么走都不可能跑一圈了
        return start;
    }
}
