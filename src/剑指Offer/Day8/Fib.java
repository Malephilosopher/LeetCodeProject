package 剑指Offer.Day8;

public class Fib {

    public int fib(int n) {
        final int MOD = 1000000007;
        if(n <= 1) return n;
        int[] dp = new int[2];
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            dp[i & 1] = (dp[0] + dp[1]) % MOD;
        }
        return dp[n & 1];

    }
}
