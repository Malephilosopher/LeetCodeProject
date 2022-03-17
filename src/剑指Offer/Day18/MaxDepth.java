package 剑指Offer.Day18;

public class MaxDepth {

    int max;

    public int maxDepth(TreeNode root) {
        max = 0;
        dfs(root, 0);
        return max;
    }

    public void dfs(TreeNode root, int depth){
        if(root == null){
            max = Math.max(max, depth);
            return;
        }

        dfs(root.left == null ? null : root.left, depth + 1);
        dfs(root.right == null ? null : root.right, depth + 1);

    }

}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }