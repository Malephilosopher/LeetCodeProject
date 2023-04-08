package WeekCompetition.Week_292;

public class P3 {

    public static final int MOD = 1000000007;

    public static int countTexts(String pressedKeys) {
        int n = pressedKeys.length();
        int[] dic = new int[]{0, 0, 3, 3, 3, 3, 3, 4, 3, 4};
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        int count = 1;
        char pre = pressedKeys.charAt(0);
        for (int i = 2; i <= n; i++) {
            char c = pressedKeys.charAt(i - 1);
            if(c == pre){
                count++;
            }else {
                count = 1;
                pre = c;
                dp[i] = dp[i - 1];
                continue;
            }
            int d = dic[Character.getNumericValue(c)];
            if(count == 2){
                dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
            }else if(count == 3){
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
            }else if(d == 3 && count > 3){
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
            }else if(d == 4 && count >= 4){
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]) % MOD;
            }
        }
        return (int) (dp[n] % MOD);
    }

    public static void main(String[] args) {
        System.out.println(countTexts("444444444444444444444444444444448888888888888888999999999999333333333333333366666666666666662222222222222222666666666666666633333333333333338888888888888888222222222222222244444444444444448888888888888222222222222222288888888888889999999999999999333333333444444664"));
    }
}
