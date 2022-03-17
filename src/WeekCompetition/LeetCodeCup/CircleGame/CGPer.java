package WeekCompetition.LeetCodeCup.CircleGame;

import java.util.*;

public class CGPer {

    public int circleGame(int[][] toys, int[][] circles, int r) {
        int ans = 0;
        Arrays.sort(circles, (o1, o2) -> o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0]);
        Deque<int[]> toyQueue = new LinkedList<>(Arrays.asList(toys));
        while (!toyQueue.isEmpty()){
            int[] toy = toyQueue.pop();
            double x1 = toy[0];
            double y1 = toy[1];
            int r1 = toy[2];
            int left = 0;
            int right = circles.length - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                if (circles[mid][0] < x1) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            boolean flag = false;
            int index = left - 1;
            while (index >= 0 && Math.abs(circles[index][0] - x1) <= r - r1) {
                int x = circles[index][0];
                int y = circles[index][1];
                double d = Math.sqrt(Math.pow(x - x1 , 2) + Math.pow(y - y1 , 2));
                if (r >= d + r1) {
                    flag = true;
                    break;
                }
                index--;
            }
            if (flag) {
                ans++;
                continue;
            }
            index = left;
            while (index < circles.length && Math.abs(circles[index][0] - x1) <= r - r1) {
                int x = circles[index][0];
                int y = circles[index][1];
                double d = Math.sqrt(Math.pow(x - x1 , 2) + Math.pow(y - y1 , 2));
                if (r >= d + r1) {
                    flag = true;
                    break;
                }
                index++;
            }
            if (flag) {
                ans++;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] toys = {{1, 3, 2}, {4, 3, 1}};
        int[][] circles = {{1, 0}, {3, 3}, {0, 0}, {3, 4}};
        CGPer cgPer = new CGPer();
        System.out.println(cgPer.circleGame(toys, circles, 4));
    }
}
