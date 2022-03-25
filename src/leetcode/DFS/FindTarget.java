package leetcode.DFS;

import java.util.ArrayDeque;
import java.util.Deque;

public class FindTarget {

    public boolean findTarget(TreeNode root, int k) {
        Deque<TreeNode> ld = new ArrayDeque<>(), rd = new ArrayDeque<>();
        TreeNode temp = root;
        while (temp != null) {
            ld.addLast(temp);
            temp = temp.left;
        }
        temp = root;
        while (temp != null) {
            rd.addLast(temp);
            temp = temp.right;
        }
        TreeNode l = ld.peekLast(), r = rd.peekLast();
        while (l.val < r.val) {
            int t = l.val + r.val;
            if (t == k) return true;
            else if (t < k) l = getNext(ld, true);
            else r = getNext(rd, false);
        }
        return false;
    }
    TreeNode getNext(Deque<TreeNode> d, boolean isLeft) {
        TreeNode cur = d.pollLast();
        TreeNode node = isLeft ? cur.right : cur.left;
        while (node != null) {
            d.addLast(node);
            node = isLeft ? node.left : node.right;
        }
        return d.peekLast();
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
