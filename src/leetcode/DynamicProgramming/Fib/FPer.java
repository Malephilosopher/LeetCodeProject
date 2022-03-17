package leetcode.DynamicProgramming.Fib;

public class FPer {

    public int fib(int n) {
        if(n == 0) return 0;
        int[] dp = new int[2];
        dp[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int sum = dp[0] + dp[1];
            dp[0] = dp[1];
            dp[1] = sum;
        }
        return dp[1];
    }
}
