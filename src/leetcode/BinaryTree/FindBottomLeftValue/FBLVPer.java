package leetcode.BinaryTree.FindBottomLeftValue;

import java.util.Deque;
import java.util.LinkedList;

//如果需要遍历整颗树，递归函数就不能有返回值。
// 如果需要遍历某一条固定路线，递归函数就一定要有返回值！
public class FBLVPer {
    public int findBottomLeftValue(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            ans = queue.peekFirst().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
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