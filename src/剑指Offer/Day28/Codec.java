package 剑指Offer.Day28;

import java.util.Deque;
import java.util.LinkedList;

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if(root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            sb.append((node == null ? "null" : node.val) + ",");
            queue.offer(node.left == null ? null : node.left);
            queue.offer(node.right == null ? null : node.right);
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int len = nodes.length;
        for (int i = 0; i < len; i++) {
            int l = 2 * i + 1;
            int r = 2 * i + 2;
            if(l >= len)continue;
            TreeNode cur = null;
            if(i == 0) cur = root;
            else cur = new TreeNode(Integer.parseInt(nodes[i]));
            if(nodes[l] != "null"){
                TreeNode left = new TreeNode(Integer.parseInt(nodes[l]));
                cur.left = left;
            }
            if(nodes[r] != "null") {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[r]));
                cur.right = right;
            }
        }

        return root;
    }
}
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}