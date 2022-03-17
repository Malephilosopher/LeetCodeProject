package leetcode.BinaryTree.GetMinimumDifference;

public class GMDPer {

    int result = Integer.MAX_VALUE;
    TreeNode pre;
    public void traversal(TreeNode cur) {
        if (cur == null) return;
        traversal(cur.left);   // 左
        if (pre != null){       // 中
            result = Math.min(result, cur.val - pre.val);
        }
        pre = cur; // 记录前一个
        traversal(cur.right);  // 右
    }
    public int getMinimumDifference(TreeNode root) {
        traversal(root);
        return result;
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