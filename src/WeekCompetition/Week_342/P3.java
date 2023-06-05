package WeekCompetition.Week_342;

import java.util.*;

public class P3 {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] rs = new int[nums.length - k + 1];
        // 构造有序哈希表，key=元素值，value=元素索引列表。按key从小到大排序
        TreeMap<Integer, List<Integer>> valIndexTreeMap = new TreeMap<>();
        // 滑动窗口左右区间
        int left = 0;
        int right = 0;
        for (; left < rs.length; left++, right++) {
            if (left == 0) {
                // 初始化
                for (; right < k; right++) {
                    List<Integer> indexLs = valIndexTreeMap.get(nums[right]);
                    if (indexLs == null) {
                        indexLs = new ArrayList<>();
                        valIndexTreeMap.put(nums[right], indexLs);
                    }
                    indexLs.add(right);
                }
                right--;
            }
            if (left > 0) {
                // 滑动窗口，每次移动1位：更新队列，删除旧值，插入新值
                List<Integer> oldIndexLs = valIndexTreeMap.get(nums[left - 1]);
                if (oldIndexLs.size() == 1) {
                    valIndexTreeMap.remove(nums[left - 1], oldIndexLs);
                } else {
                    oldIndexLs.remove(0);
                }
                List<Integer> newIndexLs = valIndexTreeMap.get(nums[right]);
                if (newIndexLs == null) {
                    newIndexLs = new ArrayList<>();
                    valIndexTreeMap.put(nums[right], newIndexLs);
                }
                newIndexLs.add(right);
            }
            // 获取当前第x小元素
            int j = 0;
            for (Map.Entry<Integer, List<Integer>> entry : valIndexTreeMap.entrySet()) {
                j += entry.getValue().size();
                // 值可能相同
                if (j >= x) {
                    rs[left] = entry.getKey() < 0 ? entry.getKey() : 0;
                    break;
                }
            }
        }
        return rs;

    }

    public int[] getSubarrayBeauty1(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        TreeMap<Integer, Integer> min = new TreeMap<>();// 保存最小的x个数
        TreeMap<Integer, Integer> max = new TreeMap<>();// 保存最大的k-x个数
        for (int i = 0; i < n; ++i) {
            // 先放min里面
            min.put(nums[i], min.getOrDefault(nums[i], 0) + 1);
            if (i >= x) {// min超过x个，需要从min拿出最大的数给max
                Map.Entry<Integer, Integer> last = min.lastEntry();
                if (last.getValue() == 1) min.pollLastEntry();
                else min.put(last.getKey(), last.getValue() - 1);
                max.put(last.getKey(), max.getOrDefault(last.getKey(), 0) + 1);
            }
            if (i >= k) {// 总数超过k个
                if (max.containsKey(nums[i - k])) {// nums[i - k]在max里
                    // 移除
                    int val = max.get(nums[i - k]);
                    if (val == 1) max.remove(nums[i - k]);
                    else max.put(nums[i - k], val - 1);
                } else {// nums[i - k]在min里
                    // 移除
                    int val = min.get(nums[i - k]);
                    if (val == 1) min.remove(nums[i - k]);
                    else min.put(nums[i - k], val - 1);
                    // 移除之后，min少于x个，需要从max拿出最小值给min
                    Map.Entry<Integer, Integer> first = max.firstEntry();
                    if (first.getValue() == 1) max.pollFirstEntry();
                    else max.put(first.getKey(), first.getValue() - 1);
                    min.put(first.getKey(), min.getOrDefault(first.getKey(), 0) + 1);
                }
            }
            // min里最大的数即为排名x的数
            if (i >= k - 1) ans[i - k + 1] = Math.min(min.lastKey(), 0);
        }
        return ans;
    }





    public static void main(String[] args) {
        P3 p = new P3();
        System.out.println(p.getSubarrayBeauty(new int[]{1, -1, -3, -2, 3}, 3, 2));
    }
}
