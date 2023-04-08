package WeekCompetition.Week_335;

public class P1 {

    //https://leetcode.com/problems/pass-the-pillow/

    public int passThePillow(int n, int time) {
        int T = (n - 1) << 1;
        int cnt = time % T;
        if(cnt <= n - 1){
            return 1 + cnt;
        }else {
            int cnt2 = cnt % (n - 1);
            return n - cnt2;
        }


    }
}
