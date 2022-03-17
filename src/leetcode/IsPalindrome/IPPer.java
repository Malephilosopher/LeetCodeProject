package leetcode.IsPalindrome;

public class IPPer {
    public static boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        boolean ans = false;
        if(s.length() == 1) return true;
        for (int i = 0; i < s.length() >> 1; i++) {
            if(s.charAt(i) == s.charAt(s.length() - 1 - i))
            {
                ans = true;
            }else {
                ans = false;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int x = 1000021;
        System.out.println(isPalindrome(x));
    }
}
