package US.DP.BackpackDP.OnesAndZeros;

public class Solution {

    //https://leetcode.com/problems/ones-and-zeroes/

    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        int[][][] dp = new int[len + 1][m + 1][n + 1];

        //precalculate the 0s and 1s of each string
        int[][] values = new int[len][2];
        for (int i = 0; i < len; i++) {
            String s = strs[i];
            int[] value = new int[2];
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '0')value[0]++;
                else value[1]++;
            }
            values[i] = value;
        }

        for (int k = 1; k <= len; k++) {
            int zero = values[k - 1][0];
            int one = values[k - 1][1];
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= n; j++) {
                    if(i < zero || j < one) dp[k][i][j] = dp[k - 1][i][j];
                    else dp[k][i][j] = Math.max(dp[k - 1][i][j], dp[k - 1][i - zero][j - one] + 1);
                }
            }
        }

        return dp[len][m][n];

    }

    public int maxValue(int N, int C, int[] v, int[] w) {
        int[] dp = new int[C + 1];
        for (int i = 0; i < N; i++) {
            //由于正序遍历会覆盖上一层状态的值，所以要逆序遍历
            for (int j = C; j >= v[i]; j--) {
                // 不选该物品
                int n = dp[j];
                // 选择该物品
                int y = dp[j - v[i]] + w[i];
                dp[j] = Math.max(n, y);
            }
        }
        return dp[C];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxValue(3, 4, new int[]{4, 2, 3}, new int[]{4, 2, 3}));
    }


}
