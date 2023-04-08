package WeekCompetition.Week_288;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class largestInteger {

    public int largestInteger(int num) {
        if(num == 1)return num;
        String s = String.valueOf(num);
        int n = s.length();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(s.substring(i, i + 1));
        }
        boolean[] isOdd = new boolean[n];
        List<Integer> odds = new ArrayList<>();
        List<Integer> evens = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if((nums[i] & 1) == 1){
                isOdd[i] = true;
                odds.add(nums[i]);
            }else {
                evens.add(nums[i]);
            }
        }

        odds.sort((a, b)->(b - a));
        evens.sort((a, b)->(b - a));

        for (int i = 0; i < n; i++) {
            if(isOdd[i] && !odds.isEmpty()){
                nums[i] = odds.get(0);
                odds.remove(0);
            }else if(!isOdd[i] && !evens.isEmpty()){
                nums[i] = evens.get(0);
                evens.remove(0);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int n1: nums) {
            sb.append(n1);
        }
        return Integer.parseInt(sb.toString());







    }
}
