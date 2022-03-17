package leetcode.greedy.MonotoneIncreasingDigits;

import java.util.ArrayList;
import java.util.List;

public class MIPer {

    public int monotoneIncreasingDigits(int n) {
        String s = String.valueOf(n);
        List<Integer> digits = new ArrayList<>();
        int len = s.length();
        int first = Integer.parseInt(s.substring(0, 1));
        for (int i = 0; i < len; i++) {
            digits.add(Integer.parseInt(s.substring(i, i + 1)));
        }
        int pos = len;
        for (int i = len - 1; i > 0; i--) {
            if(digits.get(i - 1) > digits.get(i)){
                pos = i;
                digits.set(i - 1, digits.get(i - 1) - 1);
            }
        }
        for (int i = pos; i < len; i++) {
            digits.set(i, 9);
        }
        int ans = 0;
        for (int i = 0; i < len; i++) {
            ans += digits.get(len - 1 - i) * Math.pow(10, i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int n = 10;
        MIPer miPer = new MIPer();
        System.out.println(miPer.monotoneIncreasingDigits(n));
    }

}
