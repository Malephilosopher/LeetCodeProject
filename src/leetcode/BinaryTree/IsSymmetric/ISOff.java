package IsSymmetric;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class ISOff {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Deque<TreeNode> que = new LinkedList<>();
        que.push(root.left);   // 将左子树头结点加入队列
        que.push(root.right);  // 将右子树头结点加入队列
        while (!que.isEmpty()) {  // 接下来就要判断这这两个树是否相互翻转
            TreeNode leftNode = que.pop();
            TreeNode rightNode = que.pop();
            if (leftNode == null && rightNode == null) {  // 左节点为空、右节点为空，此时说明是对称的
                continue;
            }

            // 左右一个节点不为空，或者都不为空但数值不相同，返回false
            if ((leftNode == null || rightNode == null || (leftNode.val != rightNode.val))) {
                return false;
            }
            que.push(leftNode.left);   // 加入左节点左孩子
            que.push(rightNode.right); // 加入右节点右孩子
            que.push(leftNode.right);  // 加入左节点右孩子
            que.push(rightNode.left);  // 加入右节点左孩子
        }
        return true;
    }
}
