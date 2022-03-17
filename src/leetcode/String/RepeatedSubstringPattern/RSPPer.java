package leetcode.String.RepeatedSubstringPattern;

public class RSPPer {

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        if(n == 0) return false;
        char[] chars = s.toCharArray();
        int[] next = new int[n];
        getNext(next, chars);
        if (next[n - 1] != -1 && n % (n - (next[n - 1] + 1)) == 0) {
            return true;
        }
        return false;
    }

    public static void getNext(int[] next, char[] chars)
    {
        next[0] = -1;
        int j = -1;
        int n = chars.length;
        for (int i = 1; i < n; i++) {
            while(j >= 0 && chars[i] != chars[j + 1])
            {
                j = next[j];
            }
            if(chars[i] == chars[j + 1])
            {
                j++;
            }
            next[i] = j;
        }
    }
}
