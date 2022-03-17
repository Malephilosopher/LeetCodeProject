package IsBalanced;


//自顶向下的递归
public class IBPer {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
        {
            return true;
        }else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root)
    {
        if(root == null)
        {
            return 0;
        }else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
