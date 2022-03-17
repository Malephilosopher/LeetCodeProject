package IsSymmetric;


public class ISPer {
    public boolean isSymmetric(TreeNode root) {
        if(root == null) return false;
        return compare(root.left, root.right);
    }

    public boolean compare(TreeNode left, TreeNode right)
    {
        // 首先排除空节点的情况
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
            // 排除了空节点，再排除数值不相同的情况
        else if (left.val != right.val) return false;
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return outside && inside;
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