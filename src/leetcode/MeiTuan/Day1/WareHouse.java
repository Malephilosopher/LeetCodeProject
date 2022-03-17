package leetcode.MeiTuan.Day1;

import java.util.*;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/30 17:53
 */
public class WareHouse {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] line2 = scanner.nextLine().split(" ");
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            if("".equals(line2[i])) continue;
            w[i] = Integer.parseInt(line2[i]);
        }
        //前缀和数组
        int[] prefixSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = w[i] + prefixSum[i];
        }

        String[] line3 = scanner.nextLine().split(" ");
        //每次取出的货物编号
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(line3[i]);
        }

        int[] ans = new int[n];

        TreeSet<Integer> boundaries = new TreeSet<>();
        boundaries.add(0);
        boundaries.add(n + 1);
        TreeMap<Integer, Integer> sums = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int pos = number[i]; //每次拿出的货物编号，等于下标+1
            int left = boundaries.lower(pos); //boundaries中比pos小的最大的数
            int right = boundaries.higher(pos); //boundaries中比pos大的最小的数
            boundaries.add(pos);

            int segSum = prefixSum[right - 1] - prefixSum[left];
            Integer count = sums.get(segSum);
            if(count != null){
                if(count == 1){
                    sums.remove(segSum);
                }else {
                    sums.put(segSum, count - 1);
                }
            }

            int leftSum = prefixSum[pos - 1] - prefixSum[left];
            int rightSum = prefixSum[right - 1] - prefixSum[pos];
            sums.put(leftSum, sums.getOrDefault(leftSum, 0) + 1);
            sums.put(rightSum, sums.getOrDefault(rightSum, 0) + 1);
            ans[i] = sums.lastKey();
        }
        for (int i = 0; i < n; i++) {
            System.out.println(ans[i]);
        }

    }
}
