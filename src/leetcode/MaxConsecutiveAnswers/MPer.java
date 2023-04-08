package leetcode.MaxConsecutiveAnswers;

public class MPer {

    static String s;
    static int n, k;
    public static int maxConsecutiveAnswers(String answerKey, int _k) {
        s = answerKey;
        n = s.length(); k = _k;
        return Math.max(getCnt('T'), getCnt('F'));
    }
    static int getCnt(char c) {
        int ans = 0;
        for (int i = 0, j = 0, cnt = 0; i < n; i++) {
            if (s.charAt(i) == c) cnt++;
            while (cnt > k) {
                if (s.charAt(j) == c) cnt--;
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(maxConsecutiveAnswers("TTFTTFTT", 1));
    }
}
