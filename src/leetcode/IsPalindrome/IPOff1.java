package leetcode.IsPalindrome;

public class IPOff1 {
    public boolean isPalindrome(int x) {
        //x + ""将x转化为字符串
        String reversedStr = (new StringBuilder(x + "")).reverse().toString();
        return (x + "").equals(reversedStr);
    }

}
