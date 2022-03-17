package leetcode.StackAndQueue.TopKFrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TKFPer {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        int n = nums.length;
        for (int num : nums) {
            if (!fre.containsKey(num)) {
                fre.put(num, 1);
            } else {
                fre.put(num, fre.get(num) + 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o1.getValue() - o2.getValue();
            }
        });
        for (Map.Entry<Integer, Integer> e: fre.entrySet()) {
            int count = e.getValue();
            if(queue.size() == k)
            {
                if(queue.peek().getValue() < count)
                {
                    queue.poll();
                    queue.offer(e);
                }
            }else {
                queue.offer(e);
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll().getKey();
        }
        return ans;
    }
}
