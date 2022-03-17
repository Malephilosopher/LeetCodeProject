package WeekCompetition.Week_282;

import java.util.Arrays;

public class MinimumTime {

    public long minimumTime(int[] time, int totalTrips) {
        int n = time.length;
        Arrays.sort(time);
        int T = time[n - 1];
        long tripPerT = 0;
        for (int i = 0; i < n; i++) {
            tripPerT += T / time[i];
        }
        long count = totalTrips / tripPerT;

        return judge(time, totalTrips, tripPerT * count, (int) (count * T));
    }

    public long judge(int[] time, int totalTrips, long trips, int timt){
        if(totalTrips == trips) return timt;
        long t = timt;
        long trip = trips;
        while (trip < totalTrips){
            t++;
            for (int ti: time) {
                if(t % ti == 0) trip++;
            }
            if(trip >= totalTrips) break;
        }
        return t;
    }

    public static void main(String[] args) {
        MinimumTime m = new MinimumTime();
        int[] time = {39,82,69,37,78,14,93,36,66,61,13,58,57,12,70,14,67,75,91,1,34,68,73,50,13,40,81,21,79,12,35,18,71,43,5,50,37,16,15,6,61,7,87,43,27,62,95,45,82,100,15,74,33,95,38,88,91,47,22,82,51,19,10,24,87,38,5,91,10,36,56,86,48,92,10,26,63,2,50,88,9,83,20,42,59,55,8,15,48,25};
        int to = 4187;
        System.out.println(m.minimumTime(time, to));
    }
}
