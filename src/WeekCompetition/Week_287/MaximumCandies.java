package WeekCompetition.Week_287;

import java.util.Arrays;
import java.util.List;

public class MaximumCandies {

    public static int maximumCandies(int[] candies, long k) {
        int n = candies.length;
        long sum = 0;
        for (int candy : candies) {
            sum += candy;
        }
        if(sum < k)return 0;
        if(sum == k) return 1;
        int l = 0, r = 10000000;
        while (l < r){
            int m = l + ((r - l) >> 1);
            long count = 0;
            for (int j = 0; j < n; j++) {
                count += candies[j] / m;
            }
            if(count >= k){
                l = m + 1;
            }else {
                r = m;
            }
        }

        return l - 1;
    }

    public static void main(String[] args) {
        System.out.println(maximumCandies(new int[]{9,10,1,2,10,9,9,10,2,2}, 3));
    }
}
