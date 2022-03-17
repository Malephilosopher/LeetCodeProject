package WeekCompetition.Week_258.MaxProduct;

public class MPPer {

    //回溯爆搜

    StringBuilder s1 = new StringBuilder();
    StringBuilder s2 = new StringBuilder();
    int res = 1;

    public int maxProduct(String s) {
        char[] chars = s.toCharArray();
        dfs(chars, 0);
        return res;
    }

    private void dfs(char[] chars, int index){
        if(index == chars.length){
            res = Math.max(res, longestPalindromeSubseq(s1.toString()) * longestPalindromeSubseq(s2.toString()));
        }else {
            s1.append(chars[index]);
            dfs(chars, index + 1);
            s1.deleteCharAt(s1.length() - 1);
            s2.append(chars[index]);
            dfs(chars, index + 1);
            s2.deleteCharAt(s2.length() - 1);
        }
    }

    private int longestPalindromeSubseq(String s) {
        int len = s.length();
        if(len < 2) return len;
        int[][] dp = new int[len][len];
        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String s = "leetcodecom";
        MPPer mpPer = new MPPer();
        System.out.println(mpPer.maxProduct(s));
    }

}
