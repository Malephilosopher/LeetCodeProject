package leetcode.BinaryTree.HasPathSum;

public class HPSPer {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        return traversal(root, targetSum - root.val);
    }

    public boolean traversal(TreeNode cur, int count)
    {
        if(cur.left == null && cur.right == null && count == 0) return true;
        if(cur.left == null && cur.right == null) return false;

        if(cur.left != null)
        {
            if(traversal(cur.left, count - cur.left.val)) return true;
        }
        if(cur.right != null)
        {
            return traversal(cur.right, count - cur.right.val);
        }
        return false;
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