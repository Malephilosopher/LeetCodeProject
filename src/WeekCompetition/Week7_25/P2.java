package WeekCompetition.Week7_25;

import java.util.ArrayList;
import java.util.List;

public class P2 {

    private int max;

    public String maximumNumber(String num, int[] change) {
        max = Integer.parseInt(num);
        List<Character> nums = new ArrayList<>();
        for (int i = 0; i < num.length(); i++) {
            nums.add(num.charAt(i));
        }
        backtracking(num, change, 0, nums);
        return String.valueOf(max);
    }

    public void backtracking(String num, int[] change, int startIndex, List<Character> nums){
        int sum = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            stringBuilder.append(nums.get(i));
        }
        sum = Integer.parseInt(stringBuilder.toString());
        if(sum > max){
            max = sum;
        }

        for (int i = startIndex; i < num.length(); i++) {
            
            nums.set(i, String.valueOf(change[Integer.parseInt(num.substring(i, i + 1))]).charAt(0));
            backtracking(num, change, i + 1, nums);
            nums.set(i, num.charAt(i));
        }

    }

    public static void main(String[] args) {
        String num = "132";
        int[] change = {9, 8, 5, 0 ,3 ,6 ,4, 2, 6, 8};
        P2 p2 = new P2();
        System.out.println(p2.maximumNumber(num, change));
    }
}
