package WeekCompetition.Week_288;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MaximumProduct {

    static final long MOD = 1000000007;
    public static int maximumProduct(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int num: nums) {
            queue.offer(num);
        }

        while (k > 0){
            int num = queue.poll();
            num++;
            k--;
            queue.offer(num);
        }
        long ans = 1;
        while (!queue.isEmpty()){
            ans = (ans * queue.poll()) % MOD;
        }
        return (int) (ans % MOD);
    }

    public static void main(String[] args) {
        System.out.println(maximumProduct(new int[]{24,5,64,53,26,38}, 54));
    }
}

