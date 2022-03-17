package leetcode.Calculator;

import java.util.Deque;
import java.util.LinkedList;

public class CPer {
    public static int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int i = 0;
        int n = s.length();
        int ans = 0;
        while(i < n)
        {
            if(s.charAt(i) == ' ')
            {
                i++;
            }else if(s.charAt(i) == '+')
            {
                sign = ops.peek();
                i++;
            }else if(s.charAt(i) == '-')
            {
                sign = -ops.peek();
                i++;
            }else if(s.charAt(i) == '(')
            {
                ops.push(sign);
                i++;
            }else if(s.charAt(i) == ')')
            {
                ops.pop();
                i++;
            }else {
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i)))
                {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ans += num * sign;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(calculate(s));
    }
}
