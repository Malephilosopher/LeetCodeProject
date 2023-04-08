package April.Day10;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class IntegerReplacement {

    //DFS
    public int integerReplacement(int n) {
        if(n == 1){
            return 0;
        }

        if((n & 1) == 0){
            return integerReplacement(n >> 1) + 1;
        }else {
            return 2 + Math.min(integerReplacement(n / 2), integerReplacement(n / 2 + 1));
        }
    }

    /**
     * BFS
     * @param n
     * @return
     */
    public int integerReplacement1(int n) {
        if (n == 1) return 0;
        Map<Long, Integer> map = new HashMap<>();
        Deque<Long> d = new ArrayDeque<>();
        d.addLast(n * 1L);
        map.put(n * 1L, 0);
        while (!d.isEmpty()) {
            long t = d.pollFirst();
            int step = map.get(t);
            long[] ns = t % 2 == 0 ? new long[]{t / 2} : new long[]{t + 1, t - 1};
            for (long x : ns) {
                if (x == 1) return step + 1;
                if (!map.containsKey(x)) {
                    map.put(x, step + 1);
                    d.addLast(x);
                }
            }
        }
        return -1;
    }



    /**
     * 贪心
     * @param _n
     * @return
     */
    public int integerReplacement2(int _n) {
        long n = _n;
        int ans = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n >>= 1;
            } else {
                if (n != 3 && ((n >> 1) & 1) == 1) n++;
                else n--;
            }
            ans++;
        }
        return ans;
    }


}
