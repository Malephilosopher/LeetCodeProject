package leetcode.BackTracking.MaximumRequests;import java.util.HashMap;import java.util.Map;public class MPer {    public int maximumRequests(int n, int[][] requests) {        int ans = 0;        Map<Integer, Integer> map = new HashMap<>();        for (int[] request: requests) {            int from = request[0];            int to = request[1];            map.put(from, map.getOrDefault(from, 0) - 1);            map.put(to, map.getOrDefault(to, 0) + 1);        }        System.out.println(map);        return ans;    }    public static void main(String[] args) {        MPer m = new MPer();        System.out.println(m.maximumRequests(5, new int[][]{{0,1}, {1,0}, {0,1}, {1,2}, {2,0}, {3,4}}));    }}