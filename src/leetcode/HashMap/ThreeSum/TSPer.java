package leetcode.HashMap.ThreeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TSPer {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        for (int first = 0; first < n; first++) {
            if(first > 0 && nums[first] == nums[first - 1])
            {
                continue;
            }
            //如果第一个大于零，后面的爷肯定都大于零，所以直接输出结果，更快
            if(nums[first] > 0)
            {
                break;
            }
            int third = n - 1;
            int target = -nums[first];
            for (int second = first + 1; second < n; second++) {
                if(second > first + 1 && nums[second] == nums[second - 1])
                {
                    continue;
                }
                while(second < third && nums[second] + nums[third] > target)
                {
                    --third;
                }
                if(second == third)
                {
                    break;
                }
                if(nums[second] + nums[third] == target)
                {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);
                }
            }
        }

        return ans;
    }
}
