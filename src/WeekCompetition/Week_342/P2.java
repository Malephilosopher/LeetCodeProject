package WeekCompetition.Week_342;

public class P2 {

    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(i % 3 == 0)ans += i;
            else if(i % 5 == 0)ans += i;
            else if(i % 7 == 0)ans += i;
        }

        return ans;
    }
}
