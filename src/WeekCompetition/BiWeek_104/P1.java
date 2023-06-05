package WeekCompetition.BiWeek_104;

public class P1 {

    //https://leetcode.com/problems/number-of-senior-citizens/

    public int countSeniors(String[] details) {
        int n = details.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int age = Integer.parseInt(details[i].substring(11, 13));
            if(age > 60)ans++;
        }

        return ans;

    }
}
