package April.Day13;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {

    static int[] nums;
    Random random;
    Map<Integer, Integer> map;
    int idx = -1;

    public RandomizedSet() {
        random = new Random();
        map = new HashMap<>();
        nums = new int[200010];
    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }else {
            map.put(val, ++idx);
            nums[idx] = val;
            return true;
        }
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int loc = map.remove(val);
        if (loc != idx) map.put(nums[idx], loc);
        nums[loc] = nums[idx--];
        return true;

    }

    public int getRandom() {
        return nums[random.nextInt(idx + 1)];
    }

}
