package WeekCompetition.Week_288;

import java.util.ArrayList;
import java.util.List;

public class MinimizeResult {

    public String minimizeResult(String expression) {
        int n = expression.length();
        int pos = expression.indexOf('+');
        int minVal = Integer.MAX_VALUE;
        String result = "";
        for (int left = 0; left < pos; left++) {
            for (int right = pos + 1; right < n; right++) {
                String s1 = expression.substring(0, left);
                String s2 = expression.substring(left, right + 1);
                String s3 = expression.substring(right + 1);

                int r = calc(s1, s2, s3);
                if (r < minVal) {
                    minVal = r;
                    result = String.format("%s(%s)%s", s1, s2, s3);
                }
            }
        }

        return result;
    }

    public int calc(String s1, String s2, String s3) {
        String[] split = s2.split("\\+");
        int ans = Integer.parseInt(split[0]) + Integer.parseInt(split[1]);
        if (!s1.isEmpty()) {
            ans *= Integer.parseInt(s1);
        }
        if (!s3.isEmpty()) {
            ans *= Integer.parseInt(s3);
        }
        return ans;
    }


}
