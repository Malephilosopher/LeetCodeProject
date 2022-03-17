package leetcode.BinaryTree.BuildTree;

import java.util.Arrays;

public class BTPer {

    public TreeNode traversal(int[] inorder, int[] postorder) {
        if(inorder.length == 0) return null;
        int n = inorder.length;
        int cur = postorder[n - 1];
        TreeNode root = new TreeNode(cur);
        int delimiter = 0;
        for (int i = 0; i < n; i++) {
            if(inorder[i] == cur)
            {
                delimiter = i;
                break;
            }
        }

        int[] leftInorder = Arrays.copyOfRange(inorder, 0, delimiter);
        int[] rightInorder = Arrays.copyOfRange(inorder, delimiter + 1, n);

        int[] leftPostorder = Arrays.copyOf(postorder, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, leftInorder.length + rightInorder.length + 1);

        root.left = traversal(leftInorder, leftPostorder);
        root.right = traversal(rightInorder, rightPostorder);
        return root;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder)
    {
        if(inorder.length == 0 || postorder.length == 0)
        {
            return null;
        }
        return traversal(inorder, postorder);
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