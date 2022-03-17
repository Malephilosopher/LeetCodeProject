package leetcode.MeiTuan.Day2;

import java.util.*;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/2/3 9:08
 */
public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        List<int[]> orders = new ArrayList<>();
        int i = 1;
        while (n > 0) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            int profit = v + w * 2;
            orders.add(new int[]{i, profit});
            n--;
            i++;
        }
        orders.sort((o1, o2) -> {
            if (o1 == o2) {
                return o1[0] - o2[0];
            } else {
                return o2[1] - o1[1];
            }
        });
        List<Integer> ans = new ArrayList<>();
        for (int j = 0; j < m; j++) {
            ans.add(orders.get(j)[0]);
        }
        ans.sort(Comparator.comparingInt(o -> o));
        for (int j = 0; j < m; j++) {
            System.out.print(ans.get(j) + " ");
        }
    }

}
