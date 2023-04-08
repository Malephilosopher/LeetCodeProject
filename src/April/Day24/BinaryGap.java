package April.Day24;

public class BinaryGap {

    public int binaryGap(int n) {
        int ans = 0;
        int pre = Integer.numberOfTrailingZeros(lowbit(n));
        n -= lowbit(n);
        while (n > 0){
            int cur = Integer.numberOfTrailingZeros(lowbit(n));
            int dis = cur - pre;
            ans = Math.max(dis, ans);
            pre = cur;
            n -= lowbit(n);
        }


        return ans;
    }

    public int lowbit(int x){
        return x & (-x);
    }
}
