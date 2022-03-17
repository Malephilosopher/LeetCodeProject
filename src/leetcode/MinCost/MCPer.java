package leetcode.MinCost;

import java.util.Hashtable;

public class MCPer {
    public static int minCost(String s, int[] cost) {
        Hashtable<Integer, Character> words = new Hashtable<>();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            words.put(i, chars[i]);
            if(i > 0 && words.get(i - 1) == words.get(i))
            {
                if(cost[i - 1] <= cost[i])
                {
                    words.remove(i - 1);
                    ans += cost[i - 1];
                }else {
                    words.remove(i);
                    char temp = words.get(i - 1);
                    words.remove(i - 1);
                    words.put(i, temp);
                    ans += cost[i];
                    cost[i] = cost[i - 1];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String s = "aaabbbabbbb";
        int[] cost = {3,5,10,7,5,3,5,5,4,8,1};
        System.out.println(minCost(s, cost));
    }
}
