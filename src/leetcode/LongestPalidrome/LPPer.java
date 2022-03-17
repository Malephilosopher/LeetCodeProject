package leetcode.LongestPalidrome;

//方法一：中心扩散法
public class LPPer {
    public String longestPalindrome(String s) {
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len_odd = expandCenter(s, i, i);
            int len_even = expandCenter(s, i, i + 1);
            int len = Math.max(len_even, len_odd);

            if(len > end - start)
            {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);

    }

    /**
     *
     * @param s     输入的字符串
     * @param left  起始的左边界
     * @param right 起始的右边界
     * @return      回文串的长度
     */
    private int expandCenter(String s, int left, int right)
    {
        /*
        当left=right, 此时中心是一个字符，回文串的长度是奇数
        当left=right-1，此时中心是一个空隙，回文串的长度是偶数
         */
        while(left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right))
        {
            left--;
            right++;
        }
        //当循环停止时，刚好满足s.charAt(left) != s.charAt(right);
        return right - left - 1;
    }
}
