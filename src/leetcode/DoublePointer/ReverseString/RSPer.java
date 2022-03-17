package leetcode.DoublePointer.ReverseString;

public class RSPer {
    public void reverseString(char[] s) {
        int n = s.length;
        for (int i = 0; i < n >> 1; i++) {
            swapReferences(s, i, n - 1 - i);
        }
    }
    public void swapReferences(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
