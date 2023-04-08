package leetcode.BusiestServers;

import java.util.*;


public class BPer {

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        //当前空闲的服务器
        TreeSet<Integer> available = new TreeSet<Integer>();
        //正在处理请求的服务器，最先结束的排在第一
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        List<Integer> ans = new ArrayList<>();
        int n = arrival.length;
        //每个服务器当前时刻已完成的请求数
        int[] hasDone = new int[k];
        for (int i = 0; i < k; i++) {
            available.add(i);
        }

        int i = 0;
        while (i < n){
            //判断是否到处理完成的时候
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                available.add(busy.poll()[1]);
            }
            if (available.isEmpty()) {
                continue;
            }
            //找到available中大于等于i % k的最小的服务器编号
            Integer p = available.ceiling(i % k);
            if (p == null) {
                //如果没找到，就用available中编号最小的
                p = available.first();
            }
            hasDone[p]++;
            busy.offer(new int[]{arrival[i] + load[i], i});
            available.remove(p);
            i++;
        }
        int max = Arrays.stream(hasDone).max().getAsInt();
        for (int j = 0; j < k; j++) {
            if(hasDone[j] == max){
                ans.add(j);
            }
        }

        return ans;


    }

    public List<Integer> busiestServers1(int k, int[] arrival, int[] load) {
        PriorityQueue<Integer> available = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int i = 0; i < k; i++) {
            available.offer(i);
        }
        PriorityQueue<int[]> busy = new PriorityQueue<int[]>((a, b) -> a[0] - b[0]);
        int[] requests = new int[k];
        for (int i = 0; i < arrival.length; i++) {
            while (!busy.isEmpty() && busy.peek()[0] <= arrival[i]) {
                int id = busy.peek()[1];
                busy.poll();
                available.offer(i + ((id - i) % k + k) % k); // 保证得到的是一个不小于 i 的且与 id 同余的数
            }
            if (available.isEmpty()) {
                continue;
            }
            int server = available.poll() % k;
            requests[server]++;
            busy.offer(new int[]{arrival[i] + load[i], server});
        }
        int maxRequest = Arrays.stream(requests).max().getAsInt();
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < k; i++) {
            if (requests[i] == maxRequest) {
                ret.add(i);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println((-4) % 3);
    }

}
