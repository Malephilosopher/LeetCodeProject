package leetcode.HashMap.ThreeSumClosest;

import java.util.Arrays;
import java.util.HashMap;

public class TSCPer {
    public static int threeSumClosest(int[] nums, int target) {
        int first = 0;
        int second = first + 1;
        int third = second + 1;
        int n = nums.length;
        Arrays.sort(nums);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (first = 0; first < n - 2; first++) {
            for (second = first + 1; second < n - 1; second++) {
                for (third = second + 1; third < n; third++) {
                    int sum = nums[first] + nums[second] + nums[third];
                    int gap = Math.abs(sum - target);
                    map.put(sum, gap);
                }
            }
        }
        int gap = 0;
        int ans = 0;
        gap = map.get(nums[0] + nums[1] + nums[2]);
        ans = nums[0] + nums[1] + nums[2];
        for (int key: map.keySet()) {
            if(gap > map.get(key))
            {
                gap = map.get(key);
                ans = key;
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(threeSumClosest(nums, target));
    }
}
