package April.Day25;

import java.util.*;

public class Solution {

    Map<Integer, List<Integer>> map;
    Random rand;

    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.putIfAbsent(num, new ArrayList<>());
            map.get(num).add(i);
        }
    }

    public int pick(int target) {
        List<Integer> indexs = map.get(target);
        int size = indexs.size();
        if(size == 1)return indexs.get(0);
        return indexs.get(rand.nextInt(size));
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1,2,3,3,3});
        System.out.println(solution.map);
    }

    int[] nums;
    Random random;

//    public Solution(int[] nums) {
//        this.nums = nums;
//        random = new Random();
//    }

    public int pick1(int target) {
        int ans = 0;
        for (int i = 0, cnt = 0; i < nums.length; ++i) {
            if (nums[i] == target) {
                ++cnt; // 第 cnt 次遇到 target
                if (random.nextInt(cnt) == 0) {
                    ans = i;
                }
            }
        }
        return ans;
    }

}
