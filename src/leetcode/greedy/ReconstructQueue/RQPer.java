package leetcode.greedy.ReconstructQueue;

import java.util.*;
import java.util.concurrent.ForkJoinPool;

public class RQPer {

    public int[][] reconstructQueue(int[][] people) {
        int n = people.length;
        int[][] queue = new int[n][2];
        List<int[]> list = new LinkedList<>();
        Arrays.sort(people, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return b[0] - a[0];
        });
//        for (int i = 0; i < n; i++) {
//            if(i > 0){
//                for (int j = i - 1; j >= 0 && compare(people[j], people[j + 1]); j--) {
//                    int[] temp = people[j];
//                    people[j] = people[j + 1];
//                    people[j + 1] = temp;
//                }
//            }
//        }
        for (int i = 0; i < n; i++) {
            int front = people[i][1];
            list.add(front, people[i]);
        }
        for (int i = 0; i < n; i++) {
            queue[i] = list.get(i);
        }
        return queue;
    }

    public boolean compare(int[] a, int[] b){
        if(a[0] == b[0]){
            return a[1] > b[1];
        }
        return a[0] < b[0];
    }

    public static void main(String[] args) {
        int[][] people = {{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
        RQPer rqPer = new RQPer();
        System.out.println(Arrays.deepToString(rqPer.reconstructQueue(people)));
    }
}

