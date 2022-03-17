package WeekCompetition.Week_258.MaxProduct;

import java.util.ArrayList;
import java.util.List;

public class MPOff {

    //状态压缩
    private boolean check(char[] s, int state) {
        int left = 0, right = s.length - 1;

        // 检查 state 对应的子序列是不是回文串
        while (left < right) {
            // 将 left 和 right 对应上 「状态所对应的字符」 位置
            while (left < right && (state >> left & 1) == 0) {
                left++;
            }
            while (left < right && (state >> right & 1) == 0) {
                right--;
            }
            if (s[left] != s[right]) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }

    public int maxProduct(String s) {
        int n = s.length(), m = 1 << n;
        List<int[]> list = new ArrayList<>();
        char[] str = s.toCharArray();

        // 记录所有合法状态的信息
        for (int i = 1; i < m; i++) {
            if (check(str, i)) {
                list.add(new int[]{ i, Integer.bitCount(i) });
            }
        }

        int[][] arr = list.toArray(new int[0][0]);
        int res = 0, len = arr.length;
        // for-each 优化，j 不需要从 0 开始
        for (int i = 0; i < len; i++) {
            int x = arr[i][0], len_x = arr[i][1];
            for (int j = i + 1; j < len; j++) {
                int y = arr[j][0], len_y = arr[j][1];
                // 状态之间没有字符相交，满足题意
                if ((x & y) == 0) {
                    res = Math.max(res, len_x * len_y);
                }
            }
        }

        return res;
    }


}
