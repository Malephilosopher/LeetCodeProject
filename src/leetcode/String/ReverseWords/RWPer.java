package leetcode.String.ReverseWords;

import java.util.ArrayDeque;
import java.util.Deque;

public class RWPer {
    public String reverseWords(String s) {
        int left = 0;
        int right = s.length() - 1;
        //去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> deque = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while(left <= right)
        {
            char c = s.charAt(left);
            if(c != ' ')
            {
                word.append(c);
            }else if(word.length() != 0){
                deque.offerFirst(word.toString());
                word.setLength(0);
            }
            ++left;
        }
        deque.offerFirst(word.toString());
        return String.join(" ", deque);
    }
}
