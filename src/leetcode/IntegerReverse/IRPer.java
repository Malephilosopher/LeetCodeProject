package leetcode.IntegerReverse;

import java.util.ArrayList;
import java.util.List;

public class IRPer {
    public static int reverse(int x) {
        int temp = x < 0 ? (-1) * x : x;
        int ans = 0;
        List<Integer> num = new ArrayList<>();
        while (temp > 0)
        {
            num.add(temp % 10);
            temp /= 10;
        }

        for (int i = 0; i < num.size(); i++) {
            ans += num.get(i) * Math.pow(10, num.size() - 1 - i);
        }
        if(ans <= (-1) * Math.pow(2, 31) || ans >= Math.pow(2, 31) - 1)
        {
            return 0;
        }
        if(x < 0)
        {
            ans *= -1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
