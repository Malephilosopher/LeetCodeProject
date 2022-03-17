package leetcode.Array.TotalMoney;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/15 18:13
 */
public class TPer {

    public int totalMoney(int n) {
        int ans = 0;
        int pre = 0;
        for (int i = 1; i <= n; i++) {
            if((i - 1) % 7 == 0 && i != 1){
                pre -= 5;
            }else {
                pre++;
            }
            ans += pre;
        }
        return ans;
    }
}
