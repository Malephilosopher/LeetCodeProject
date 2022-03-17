package 剑指Offer.Day6;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder {


    public int[] levelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        if(root == null) return new int[0];
        treeNodeDeque.offer(root);

        while (!treeNodeDeque.isEmpty()){
            TreeNode node = treeNodeDeque.poll();
            list.add(node.val);
            if(node.left != null) treeNodeDeque.offer(node.left);
            if(node.right != null) treeNodeDeque.offer(node.right);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}