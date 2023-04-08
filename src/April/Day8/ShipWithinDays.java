package April.Day8;

import java.util.Arrays;

public class ShipWithinDays {

    public static int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int max = 0, sum = 0;
        for (int w : weights) {
            max = Math.max(max, w);
            sum += w;
        }
        int l = sum / days, r = sum;
        while (l < r) {
            int mid = l + r >> 1;
            if (canShip(mid, weights, days)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public static boolean canShip(int cap, int[] weights, int days){
        int n = weights.length;
        int p = 0;
        for (int i = 0; i < days; i++) {
            int ship = 0;
            for (; p < n; p++) {
                if(ship + weights[p] > cap){
                    break;
                }
                ship += weights[p];
            }
        }
        return p == n;
    }

    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(canShip(15, weights, 5));
    }

}
