package leetcode.CountKDifference;

public class COff1 {
    //占坑思想
    public int countKDifference(int[] nums, int k) {
        int[] cnt = new int[101];//数据范围是1到100
        //记录每个值的频次
        for (int num: nums) cnt[num]++;
        int ans = 0;
        for (int i = 1; i <= 100 - k; i++) {
            ans += cnt[i] * cnt[i + k]; //i和i + k排列组合
        }
        return ans;
    }
}
