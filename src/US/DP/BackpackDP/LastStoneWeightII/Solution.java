package US.DP.BackpackDP.LastStoneWeightII;

public class Solution {

    //https://leetcode.com/problems/last-stone-weight-ii/


    /*
    convert to the 01 backpack problem of getting the max sum smaller than sum / 2
     */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int stone: stones) {
            sum += stone;
        }
        int target = sum >> 1;

        int[] dp = new int[target + 1];

        for (int i = 0; i < n; i++) {
            int stone = stones[i];

            for (int j = target; j >= stone; j--) {
                //not choose
                int notChoose = dp[j];
                //choose
                int choose = dp[j - stone] + stone;

                dp[j] = Math.max(notChoose, choose);

            }

        }

        return Math.abs(sum - dp[target] * 2);

    }
}
