package DoubleWeek_61.FindOriginalArray;

import java.net.Inet4Address;
import java.util.*;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/18 23:08
 */
public class Fper {

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;
        if (n % 2 == 1) return new int[]{};
        // 保证较小数先遍历到，因为最小的数肯定是原始数组里的
        Arrays.sort(changed);
        Map<Integer, Integer> cache = new HashMap<>();
        int cnt = 0;
        List<Integer> resList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cache.getOrDefault(changed[i], 0) > 0) {
                // 当前元素作为双倍元素匹配
                cnt++;
                cache.put(changed[i], cache.get(changed[i]) - 1);
                resList.add(changed[i] / 2);
            } else {
                // 当前元素作为原始元素匹配
                cache.put(changed[i] * 2, cache.getOrDefault(changed[i] * 2, 0) + 1);
            }
        }
        if (cnt != n / 2) return new int[]{};
        int[] res = new int[n / 2];
        for (int i = 0; i < res.length; i++) res[i] = resList.get(i);
        return res;


    }

    public static void main(String[] args) {
        int[] changed = {1,2,3,2,4,6,2,4,6,4,8,12};
        Fper fper = new Fper();
        System.out.println(Arrays.toString(fper.findOriginalArray(changed)));
    }
}
