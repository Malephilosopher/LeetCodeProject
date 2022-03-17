package leetcode.StackAndQueue.EvalRPN;

import java.util.Deque;
import java.util.LinkedList;

public class ERPer {
    public static int evalRPN(String[] tokens) {
        Deque<Integer> stack = new LinkedList<>();
        for (String s: tokens) {
            char c = s.charAt(0);
            if(isNum(s))
            {
                stack.push(Integer.parseInt(s));
            }else if(c == '+')
            {
                stack.push(stack.pop() + stack.pop());
            }else if(c == '-')
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b - a);
            }else if(c == '*')
            {
                stack.push(stack.pop() * stack.pop());
            }else if(c == '/')
            {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b / a);
            }
        }
        return stack.pop();
    }

    public static boolean isNum(String s){
        try {
            int num = Integer.parseInt(s);//把字符串强制转换为数字

            return true;//如果是数字，返回True

        } catch (Exception e) {
            return false;//如果抛出异常，返回False
        }
    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(tokens));
    }
}
