package leetcode.BinaryTree.TrimBST;

public class TBPer {

    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null ) return null;
        if (root.val < low) {
            TreeNode right = trimBST(root.right, low, high); // 寻找符合区间[low, high]的节点
            return right;
        }
        if (root.val > high) {
            TreeNode left = trimBST(root.left, low, high); // 寻找符合区间[low, high]的节点
            return left;
        }
        root.left = trimBST(root.left, low, high); // root->left接入符合条件的左孩子
        root.right = trimBST(root.right, low, high); // root->right接入符合条件的右孩子
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