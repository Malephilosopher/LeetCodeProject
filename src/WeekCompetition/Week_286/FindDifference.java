package WeekCompetition.Week_286;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDifference {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int n1 = nums1.length;
        int n2 = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        for (int num: nums1) {
            if(!map1.containsKey(num)){
                map1.put(num, 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int num: nums2) {
            if(!map2.containsKey(num)) {
                map2.put(num, 1);
            }
        }
        for (int key: map1.keySet()) {
            if(!map2.containsKey(key)){
                list1.add(key);
            }
        }
        for (int key: map2.keySet()) {
            if(!map1.containsKey(key)){
                list2.add(key);
            }
        }
        ans.add(list1);
        ans.add(list2);
        return ans;
    }
}
