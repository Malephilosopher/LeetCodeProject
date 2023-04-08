package April.Day1;

import java.util.*;

public class CanReorderDoubled {

    public boolean canReorderDoubled(int[] arr) {
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int x : arr) {
            cnt.put(x, cnt.getOrDefault(x, 0) + 1);
        }
        if (cnt.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }

        List<Integer> vals = new ArrayList<>(cnt.keySet());
        vals.sort(Comparator.comparingInt(Math::abs));

        for (int x : vals) {
            if (cnt.getOrDefault(2 * x, 0) < cnt.get(x)) { // 无法找到足够的 2x 与 x 配对
                return false;
            }
            cnt.put(2 * x, cnt.getOrDefault(2 * x, 0) - cnt.get(x));
        }
        return true;
    }

    static int N = 100010, M = N * 2;
    static int[] cnts = new int[M * 2];
    public boolean canReorderDoubled1(int[] arr) {
        Arrays.fill(cnts, 0);
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            //统计频次，同时避免加入重复的数
            if (++cnts[i + M] == 1) list.add(i);
        }
        //按绝对值排序
        Collections.sort(list, (a,b)->Math.abs(a)-Math.abs(b));
        for (int i : list) {
            //如果2*i的个数不够i配对（一个i消耗一个2*i）
            if (cnts[i * 2 + M] < cnts[i + M]) return false;
            cnts[i * 2 + M] -= cnts[i + M];
        }
        return true;
    }


}

