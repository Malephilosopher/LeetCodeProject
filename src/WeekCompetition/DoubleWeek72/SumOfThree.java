package WeekCompetition.DoubleWeek72;

public class SumOfThree {

    public long[] sumOfThree(long num) {
        long[] ans = new long[3];
        for (long i = 0; i < num / 3; i++) {
            if(3 * i + 3 == num){
                ans[0] = i;
                ans[1] = i + 1;
                ans[2] = i + 2;
                return ans;
            }else if(3 * i + 3 > num){
                break;
            }
        }
        return new long[0];
    }
}
