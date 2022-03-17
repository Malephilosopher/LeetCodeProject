package leetcode.String.Convert;

import java.util.ArrayList;
import java.util.List;

public class CPer {

    public String convert(String s, int numRows) {
        int n = s.length();
        int count = 0;
        if(numRows == 1) count = n;
        else count = n / (2 * numRows - 2) + 1;
        int index = 0;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        for (int i = 0; i < count; i++) {
            for (int j = 0; j < numRows && index < n; j++, index++) {
                rows.get(j).append(s.charAt(index));
            }
            for (int k = numRows - 2; k > 0 && index < n; k--, index++) {
                rows.get(k).append(s.charAt(index));
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ans.append(rows.get(i));
        }
        return ans.toString();
    }

    public String convert1(String s, int r) {
        int n = s.length();
        if (n == 1 || r == 1) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < r; i++) {
            if (i == 0 || i == r - 1) {
                int pos = i, offset = 2 * (r - 1);
                while (pos < n) {
                    sb.append(s.charAt(pos));
                    pos += offset;
                }
            } else {
                int pos1 = i, pos2 = 2 * r - i - 2;
                int offset = 2 * (r - 1);
                while (pos1 < n || pos2 < n) {
                    if (pos1 < n) {
                        sb.append(s.charAt(pos1));
                        pos1 += offset;
                    }
                    if (pos2 < n) {
                        sb.append(s.charAt(pos2));
                        pos2 += offset;
                    }
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        CPer c = new CPer();
        System.out.println(c.convert("PAYPALISHIRING", 3));
    }
}
