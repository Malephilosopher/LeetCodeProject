package US.DP.BackpackDP.CanPartition;

import java.util.Arrays;

public class Solution {

    //https://leetcode.com/problems/partition-equal-subset-sum/


    public boolean canPartition(int[] nums) {
        int n = nums.length;

        //「等和子集」的和必然是总和的一半
        int sum = 0;
        for (int i : nums) sum += i;
        int target = sum / 2;

        // 对应了总和为奇数的情况，注定不能被分为两个「等和子集」
        if (target * 2 != sum) return false;

        // f[i][j] 代表考虑前 i 件物品，能否凑出价值「恰好」为 j 的方案
        boolean[][] f = new boolean[n + 1][target + 1];
        f[0][0] = true;
        for (int i = 1; i <= n; i++) {
            int t = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                // 不选该物品
                boolean no = f[i - 1][j];
                // 选该物品
                boolean yes = j >= t ? f[i-1][j-t] : false;
                f[i][j] = no | yes;
            }
        }
        return f[n][target];

    }
}
