package April.Day22;

import java.util.Arrays;

public class MaxRotateFunction {

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (long) i * nums[i];
        }
        long sum = Arrays.stream(nums).sum();
        long pre = ans;
        int end = n - 1;
        for (int i = 1; i < n; i++, end = (end - 1 + n) % n) {
            long temp = pre + sum - (long) n * nums[end];
            ans = Math.max(ans, temp);
            pre = temp;
        }

        return (int)ans;
    }

    public static void main(String[] args) {
        System.out.println(maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
