package April.Day4;

public class NumArray {

    int[] tree;
    int lowbit(int x) {
        return x & -x;
    }
    int query(int x) {
        //查询从 [1, x][1,x] 区间的和为多少
        int ans = 0;
        //到x位置的和等于按2的幂不断分解
        for (int i = x; i > 0; i -= lowbit(i)) ans += tree[i];
        return ans;
    }
    void add(int x, int u) {
        //在 x 的位置增加 u（注意位置下标从 1 开始）
        for (int i = x; i <= n; i += lowbit(i)) tree[i] += u;
    }

    int[] nums;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        tree = new int[n + 1];
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }

}
