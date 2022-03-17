package MinDepth;



public class MIDPer {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        int left =  minDepth(root.left);
        int right =  minDepth(root.right);
        if(root.left == null && root.right != null)
        {
            return 1 + right;
        }
        if(root.left != null && root.right == null)
        {
            return 1 + left;
        }
        int minDepth = Math.min(left, right) + 1;
        return minDepth;
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