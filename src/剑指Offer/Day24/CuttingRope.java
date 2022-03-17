package 剑指Offer.Day24;

public class CuttingRope {

    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) return (int)Math.pow(3, a);
        if(b == 1) return (int)Math.pow(3, a - 1) * 4;
        return (int)Math.pow(3, a) * 2;

    }

    public int cuttingRope1(int n) {
        int[] dp = new int[n + 1];
        for(int i = 2; i < n + 1; i ++)
        {
            int cur_max = 0;
            for(int j = 1; j < i; j ++)
            {
                cur_max = Math.max(cur_max, Math.max(j * (i - j), j * dp[i - j]));
            }
            dp[i] = cur_max;
        }
        return dp[n];
    }




}
