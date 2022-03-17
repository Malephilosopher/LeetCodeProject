package leetcode.BinaryTree.LowestCommonAncestor;

//二叉搜索树
public class LCAOff {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return root;
        // 中
        if (root.val > p.val && root.val > q.val) {   // 左
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            if (left != null) {
                return left;
            }
        }

        if (root.val < p.val && root.val < q.val) {   // 右
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null) {
                return right;
            }
        }
        return root;
    }
}
