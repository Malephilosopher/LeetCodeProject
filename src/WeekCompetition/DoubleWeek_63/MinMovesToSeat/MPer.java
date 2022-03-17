package WeekCompetition.DoubleWeek_63.MinMovesToSeat;

import java.util.Arrays;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/10/17 9:57
 */
public class MPer
{
    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(seats[i] - students[i]);
        }
        return ans;
    }
}
