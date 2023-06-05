package US.IntervalSum.DifferenceArray.CorpFlightBookings;

public class Solution {

    //https://leetcode.com/problems/corporate-flight-bookings/

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int[] booking: bookings) {
            int f = booking[0] - 1;
            int l = booking[1] - 1;
            int seats = booking[2];
            diff[f] += seats;
            diff[l + 1] -= seats;

        }

        int[] ans = new int[n];
        ans[0] = diff[0];
        for (int i = 1; i < n; i++) {
            ans[i] = ans[i - 1] + diff[i];
        }

        return ans;

    }
}
