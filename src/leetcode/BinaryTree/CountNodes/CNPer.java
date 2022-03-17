package leetcode.BinaryTree.CountNodes;

import java.util.Deque;
import java.util.LinkedList;

public class CNPer {
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty())
        {
            TreeNode node = queue.pop();
            ans++;
            if(node.left != null) queue.push(node.left);
            if(node.right != null) queue.push(node.right);
        }
        return ans;
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