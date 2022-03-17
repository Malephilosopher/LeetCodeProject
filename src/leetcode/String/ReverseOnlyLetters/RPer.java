package leetcode.String.ReverseOnlyLetters;

import java.util.*;
public class RPer {

    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right){
            while (left < right && !Character.isAlphabetic(chars[left])){
                left++;
            }
            while (left < right && !Character.isAlphabetic(chars[right])){
                right--;
            }
            if(left >= right) break;
            reverse(chars, left, right);
            left++;
            right--;
        }
        return new String(chars);
    }

    public void reverse(char[] chars, int left, int right){
        char temp = chars[right];
        chars[right] = chars[left];
        chars[left] = temp;
    }

    public static void main(String[] args) {
        RPer r = new RPer();
        System.out.println(r.reverseOnlyLetters("7_28]"));
    }
}
