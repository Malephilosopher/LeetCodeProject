package leetcode.SetZeros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
10ms 5.30% O(mn)
39.7MB 97.48% O(m+n)
 */
public class SZPer {
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<HashMap<Integer, Integer>> list = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if(matrix[row][col] == 0)
                {
                    HashMap<Integer, Integer> map = new HashMap<>();
                    map.put(row, col);
                    list.add(map);
                }
            }
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < m; j++) {
                matrix[j][(int) list.get(i).values().toArray()[0]] = 0;
            }
            for (int k = 0; k < n; k++) {
                matrix[(int) list.get(i).keySet().toArray()[0]][k] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));

    }
}
