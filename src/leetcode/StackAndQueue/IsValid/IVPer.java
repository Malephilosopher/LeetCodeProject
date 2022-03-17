package leetcode.StackAndQueue.IsValid;

import java.util.Deque;
import java.util.LinkedList;

public class IVPer {
    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') stack.push(')');
            else if (chars[i] == '{') stack.push('}');
            else if (chars[i] == '[') stack.push(']');
                // 第三种情况：遍历字符串匹配的过程中，栈已经为空了，没有匹配的字符了，说明右括号没有找到对应的左括号 return false
                // 第二种情况：遍历字符串匹配的过程中，发现栈里没有我们要匹配的字符。所以return false
            else if (stack.isEmpty() || stack.peek() != chars[i]) return false;
            else stack.pop(); // st.top() 与 s[i]相等，栈弹出元素
        }
        return stack.isEmpty();


    }
}
