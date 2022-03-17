package leetcode.Array.TotalMoney;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/15 18:32
 */
public class TOff {

    public int totalMoney(int n) {
        int weeks = n / 7;
        //完整的周的钱
        int money = weeks * 28 + weeks * (weeks - 1) * 7 / 2;
        //剩下的不完整的周的钱;
        int daysLeft = n % 7;
        int left = daysLeft * (weeks + 1) + daysLeft * (daysLeft - 1) / 2;
        return left + money;

    }
}
