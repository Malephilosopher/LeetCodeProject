package leetcode.DoublePointer.ReverseStr2;

public class RS2Per {
    public static String reverseStr(String s, int k) {
        int n = s.length();
        int cur = 0;
        char[] chars = s.toCharArray();
        if(n <= 1) return s;
        while(cur <= n - 1)
        {
            int gap = n - cur;
            if(gap < k)
            {
                for (int i = 0; i < gap >> 1; i++) {
                    swapReferences(chars, cur + i, cur + gap - 1 - i);
                }
                break;
            }
            for (int i = 0; i < k >> 1; i++) {
                swapReferences(chars, cur + i, cur + k - 1 - i);
            }
            cur += k * 2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }
    public static void swapReferences(char[] s, int left, int right)
    {
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }

    public static void main(String[] args) {
        String s = "abcd";
        System.out.println(reverseStr(s, 4));
    }
}
