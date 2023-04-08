package April.Day8;

import java.util.ArrayDeque;
import java.util.Deque;

public class IsEvenOddTree {

    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> d = new ArrayDeque<>();
        boolean flag = true;
        d.addLast(root);
        while (!d.isEmpty()) {
            int size = d.size(), prev = flag ? 0 : 0x3f3f3f3f;
            while (size-- > 0) {
                TreeNode node = d.pollFirst();
                int cur = node.val;
                if (flag && (cur % 2 == 0 || cur <= prev)) return false;
                if (!flag && (cur % 2 != 0 || cur >= prev)) return false;
                prev = cur;
                if (node.left != null) d.addLast(node.left);
                if (node.right != null) d.addLast(node.right);
            }
            flag = !flag;
        }
        return true;
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