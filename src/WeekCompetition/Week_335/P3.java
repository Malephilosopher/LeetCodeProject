package WeekCompetition.Week_335;

import java.util.*;

public class P3 {


    //https://leetcode.com/problems/split-the-array-to-make-coprime-products/description/

    public int findValidSplit(int[] nums) {
        if (nums.length == 1) {
            return -1;
        }

        // Get factors of each number, and the factor ranges
        List<Integer>[] factors = new List[nums.length];
        Map<Integer, Integer> factorEnds = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            factors[i] = new ArrayList<>();
            for (int j = 2; j * j <= nums[i]; j++) {
                if (nums[i] % j == 0) {
                    factors[i].add(j);
                    factors[i].add(nums[i] / j);
                    factorEnds.put(j, i);
                    factorEnds.put(nums[i] / j, i);
                }
            }
            factors[i].add(nums[i]);
            factorEnds.put(nums[i], i);
        }

        // Sweep line
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int factor : factors[i]) {
                end = Math.max(end, factorEnds.get(factor));
            }
            if (end == nums.length - 1) {
                break;
            }
            if (end == i) {
                return end;
            }
        }

        return -1;


    }

}
