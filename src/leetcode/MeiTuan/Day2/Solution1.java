package leetcode.MeiTuan.Day2;

import java.util.*;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/2/3 10:43
 */
public class Solution1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        Arrays.fill(B, -1);
        int m = scanner.nextInt();
        int[][] manipulates = new int[m][];
        scanner.nextLine();
        for (int i = 0; i < m; i++) {
            String[] line = scanner.nextLine().split(" ");
            int[] nums = new int[4];
            for (int j = 0; j < line.length; j++) {
                nums[j] = Integer.parseInt(line[j]);
            }
            manipulates[i] = nums;
        }

        for (int i = 0; i < m; i++) {
            int type = manipulates[i][0];
            if(type == 1){
                int k = manipulates[i][1];
                int x = manipulates[i][2];
                int y = manipulates[i][3];
                for (int j = 0; j < k && (y + j - 1) < n && (x + j - 1) < n; j++) {
                    //copy k elements from A to B
                    B[y + j - 1] = A[x + j - 1];
                }
            }else if(type == 2){
                int x = manipulates[i][1];
                if(x - 1 >= 0 && x - 1 < n){
                    System.out.println(B[x - 1]);
                }
            }
        }

    }
}
