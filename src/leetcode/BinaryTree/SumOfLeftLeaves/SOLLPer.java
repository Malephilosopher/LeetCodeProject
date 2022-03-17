package leetcode.BinaryTree.SumOfLeftLeaves;

public class SOLLPer {

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;

        int left = sumOfLeftLeaves(root.left);
        int right = sumOfLeftLeaves(root.right);

        int mid = 0;
        if(root.left != null && root.left.left == null && root.left.right == null)
        {
            mid = root.left.val;
        }

        return mid + left + right;
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