package leetcode.SlideWindow.MaxSatisfied;

public class MPer {

    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(grumpy[i] == 0) {
                ans += customers[i];
                customers[i] = 0;//关键
            }
        }

        int curSum = 0;
        int count = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            curSum += customers[i];
            count++;
            if(count > minutes){
                curSum -= customers[i - minutes];
            }
            max = Math.max(max, curSum);
        }
        return ans + max;
    }
}
