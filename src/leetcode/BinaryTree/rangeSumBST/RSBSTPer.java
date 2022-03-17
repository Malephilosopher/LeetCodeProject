package leetcode.BinaryTree.rangeSumBST;

public class RSBSTPer {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode root1 = new TreeNode(5);
        TreeNode root2 = new TreeNode(3);
        TreeNode root3 = new TreeNode(7);
        TreeNode root4 = new TreeNode(15);
        TreeNode root5 = new TreeNode(18);
        root.left = root1;
        root1.left = root2;
        root1.right = root3;
        root.right = root4;
        root4.right = root5;
        RSBSTPer r = new RSBSTPer();
        System.out.println(r.rangeSumBST(root, 7, 15));
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
