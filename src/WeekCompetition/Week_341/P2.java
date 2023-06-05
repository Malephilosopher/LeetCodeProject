package WeekCompetition.Week_341;

public class P2 {

    public int maxDivScore(int[] nums, int[] divisors) {
        int n = nums.length;
        int n1 = divisors.length;

        int maxScore = 0;
        int res = divisors[0];
        for (int i = 0; i < n1; i++) {
            int divisor = divisors[i];
            int score = 0;
            for (int j = 0; j < n; j++) {
                double num = nums[j];
                if(num % divisor == 0)score++;
            }
            if(score > maxScore){
                maxScore = score;
                res = divisor;
            }else if(score == maxScore){
                if(divisor < res) res = divisor;
            }
        }

        return res;

    }
}
