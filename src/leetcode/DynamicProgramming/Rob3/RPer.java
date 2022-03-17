package leetcode.DynamicProgramming.Rob3;

/**
 * @Author Ivan Vladimir Xu
 * @Date 2021/9/22 10:56
 */
public class RPer {

    public int rob(TreeNode root) {
        int[] dp = robTree(root);
        return Math.max(dp[0], dp[1]);
    }

    public int[] robTree(TreeNode cur){
        if(cur == null) return new int[2];

        int[] left = robTree(cur.left);
        int[] right = robTree(cur.right);

        int steal = cur.val + left[0] + right[0];
        int notSteal = Math.max(left[0] + right[1], left[1] + right[0]);

        int[] root = new int[2];
        root[1] = steal;
        root[0] = notSteal;
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}