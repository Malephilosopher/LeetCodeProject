package leetcode.LuckyNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LPer {

    public List<Integer> luckyNumbers (int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>();
        List<int[]> lines = new ArrayList<>();
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < m; i++){
            int temp = Integer.MAX_VALUE;
            int index = 0;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < temp){
                    temp = matrix[i][j];
                    index = j;
                }
            }
            lines.add(new int[]{i, index});
        }
        System.out.println(lines);
        for (int i = 0; i < n; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = 0; j < m; j++) {
                int num = matrix[j][i];
                temp = Math.max(temp, num);
            }
            rows.add(temp);
        }
        System.out.println(rows);
        for (int i = 0; i < m; i++) {
            int line = lines.get(i)[0];
            int row = lines.get(i)[1];
            int max = rows.get(row);
            if(max == matrix[line][row]){
                ans.add(max);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Double.parseDouble("$0.24"));
    }
}
