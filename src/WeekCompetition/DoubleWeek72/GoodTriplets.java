package WeekCompetition.DoubleWeek72;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoodTriplets {

//    public long goodTriplets(int[] nums1, int[] nums2) {
//        var n = nums1.length;
//        var p = new int[n];
//        for (var i = 0; i < n; ++i)
//            p[nums1[i]] = i;
//        var ans = 0L;
//        var tree = new int[n + 1];
//        for (var i = 1; i < n - 1; ++i) {
//            for (var j = p[nums2[i - 1]] + 1; j <= n; j += j & -j) // 将 p[nums2[i-1]]+1 加入树状数组
//                ++tree[j];
//            var y = p[nums2[i]];
//            var less = 0;
//            for (var j = y; j > 0; j &= j - 1) // 计算 less
//                less += tree[j];
//            ans += (long) less * (n - 1 - y - (i - less));
//        }
//        return ans;
//    }


}
