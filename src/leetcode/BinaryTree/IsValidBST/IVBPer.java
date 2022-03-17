package leetcode.BinaryTree.IsValidBST;

public class IVBPer {

    long maxVal = Long.MIN_VALUE; // 因为后台测试数据中有int最小值

    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;

        boolean left = isValidBST(root.left);         // 左
        // 中序遍历，验证遍历的元素是不是从小到大
        if (maxVal < root.val) maxVal = root.val; // 中
        else return false;

        boolean right = isValidBST(root.right);       // 右
        return left && right;
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