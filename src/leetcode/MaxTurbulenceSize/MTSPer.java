package leetcode.MaxTurbulenceSize;

import java.util.Arrays;

public class MTSPer {
    public static int maxTurbulenceSize(int[] arr) {
        int l = arr.length;
        int[] dp = new int[l];
        if(arr.length == 1) return 1;
        if(arr.length == 2)
        {
            if(arr[0] == arr[1]) return 1;
            else return 2;
        }
        for (int i = 1; i < l - 1; i++) {
            int max = dp[i - 1] + 1;
            if(arr[i - 1] > arr[i] && arr[i] < arr[i + 1])
            {
                dp[i] = max;
                if(i == 1)
                {
                    dp[i] += 2;
                }
                continue;
            }
            if(arr[i - 1] < arr[i] && arr[i] > arr[i + 1])
            {
                dp[i] = max;
                if(i == 1)
                {
                    dp[i] += 2;
                }
            }
            else if(arr[i - 1] == arr[i] && arr[i] == arr[i + 1])
            {
                dp[i] = 1;
            }
            else {
                dp[i] = 2;
            }

        }
        Arrays.sort(dp);
        return dp[l - 1];
    }

    public static void main(String[] args) {
        int[] arr = {100, 100, 100};
        System.out.println(maxTurbulenceSize(arr));
    }
}
