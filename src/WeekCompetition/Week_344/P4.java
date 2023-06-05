package WeekCompetition.Week_344;

public class P4 {

    public int minIncrements(int n, int[] cost) {
        int ans = 0;
        for (int i = n / 2; i > 0; i--) { // 从最后一个非叶节点开始算
            ans += Math.abs(cost[i * 2 - 1] - cost[i * 2]); // 两个子节点变成一样的
            cost[i - 1] += Math.max(cost[i * 2 - 1], cost[i * 2]); // 累加路径和
        }
        return ans;



    }

    public static void main(String[] args) {
        P4 p = new P4();
        System.out.println(p.minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
    }
}
