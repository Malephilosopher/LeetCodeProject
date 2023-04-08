package WeekCompetition.Week_291;

import java.util.HashSet;
import java.util.Set;

public class CountDistinct {

    public static int countDistinct(int[] nums, int k, int p) {
        int n = nums.length;
        boolean[] sign = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(nums[i] % p == 0){
                sign[i] = true;
            }
        }
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int[] sub = new int[j - i + 1];
                StringBuilder sb = new StringBuilder();
                int count = 0;
                for (int l = 0; l < j - i + 1; l++) {
                    if(sign[i + l]){
                        count++;
                    }
                    sub[l] = nums[i + l];
                    sb.append(nums[i + l]).append(",");
                }
                sb.deleteCharAt(sb.length() - 1);
                if(set.contains(sb.toString()))continue;
                if(count <= k){
                    set.add(sb.toString());
                }

            }
        }

        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(countDistinct(new int[]{2,3,3,2,2}, 2, 2));
    }
}
