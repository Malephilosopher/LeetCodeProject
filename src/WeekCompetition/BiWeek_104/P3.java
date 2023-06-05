package WeekCompetition.BiWeek_104;

public class P3 {

    public long maximumOr(int[] nums, int k) {
        long dp[] = new long[k+1];
        long tmp[] = new long[k+1];

        for(long xx:nums){
            for(int i=0;i<=k;i++){
                long max=0;
                for(int j=0;j<=i;j++){
                    max = Math.max(max, (xx<<j)|dp[i-j] );
                }
                tmp[i] = max;
            }
            dp = tmp;
            tmp = new long[k+1];
        }
        return dp[k];
    }

    public long maximumOr1(int[] A, int k) {
        int n = A.length, right[] = new int[n], left = 0;
        long res = 0;
        for (int i = n - 2; i >= 0; --i) {
            right[i] = right[i + 1] | A[i + 1];
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, left | (long)A[i] << k | right[i]);
            left |= A[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(12 | 9);

        System.out.println(new P3().maximumOr(nums, 1));
    }
}
