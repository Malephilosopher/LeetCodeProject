package leetcode.Array.NumberOfSteps;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2022/1/31 10:25
 */
public class NOff {

    public int numberOfSteps(int num) {
        return Math.max(getLoc(num) + getCnt(num) - 1, 0);
    }
    int getLoc(int x) {
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) return i + 1;
        }
        return -1; // never
    }
    int getCnt(int x) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            if (((x >> i) & 1) == 1) ans++;
        }
        return ans;
    }

}
