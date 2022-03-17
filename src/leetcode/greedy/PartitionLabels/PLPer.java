package leetcode.greedy.PartitionLabels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PLPer {

    public List<Integer> partitionLabels(String s) {
        List<Integer> result = new ArrayList<>();
        int[] lastPosition = new int[26];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            //记录每个字母最后一次出现的位置
            lastPosition[chars[i] - 'a'] = i;
        }

        int left = 0;
        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            right = Math.max(lastPosition[chars[i] - 'a'], right);
            if(i == right){
                result.add(right - left + 1);
                left = i + 1;
            }
        }
        return result;
    }
}
