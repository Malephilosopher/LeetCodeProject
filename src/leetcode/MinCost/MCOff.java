package leetcode.MinCost;

public class MCOff {
    public int minCost(String s, int[] cost) {
        int i = 0, len = s.length();
        int ret = 0;
        while (i < len) {
            char ch = s.charAt(i);
            int maxValue = 0;
            int sum = 0;

            while (i < len && s.charAt(i) == ch) {
                maxValue = Math.max(maxValue, cost[i]);
                sum += cost[i];
                i++;
            }
            ret += (sum - maxValue);
        }
        return ret;
    }
}