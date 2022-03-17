package leetcode.RangeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class RSPer {
    public int rangeSum(int[] nums, int n, int left, int right) {
        final int MODULO = 1000000007;
        //初始化一个容器存放子数组
        int length = n * (n + 1) / 2;
        List<Integer> result = new ArrayList<>(length);
        //写入子数组
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                result.add(sum);
            }
        }

        //对子数组排序
        result.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(result);

        //计算left和right之间的和
        int sum = 0;
        while (left <= right)
        {
            sum = (sum + result.get(left - 1)) % MODULO;
            left++;
        }
        return sum;
    }

    public static void main(String[] args) {
        RSPer r = new RSPer();
        int n = 4, left = 1, right = 5;
        int[] nums = {1, 2, 3, 4};

        System.out.println(r.rangeSum(nums, n, left, right));
    }
}
