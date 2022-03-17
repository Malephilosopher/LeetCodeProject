package leetcode.String.LongestNiceSubstring;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/2/2 12:14
 */
public class LPer {

    public String longestNiceSubstring(String s) {
        int n = s.length();
        int index = -1;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int a = 0, b = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if(c >= 'a' && c <= 'z') a |= (1 << (c - 'a'));
                else b |= (1 << (c - 'A'));
                if(a == b && j - i + 1 > len){
                    index = i; len = j - i + 1;
                }
            }
        }
        return index == -1 ? "" : s.substring(index, index + len);
    }
}
