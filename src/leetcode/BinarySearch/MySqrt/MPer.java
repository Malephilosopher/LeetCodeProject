package leetcode.BinarySearch.MySqrt;

public class MPer {

    //找到最大的平方比x小的数
    public int mySqrt(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if ((long) mid * mid <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        MPer m = new MPer();
        System.out.println(m.mySqrt(8));
    }
}
