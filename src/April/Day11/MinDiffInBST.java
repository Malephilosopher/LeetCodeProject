package April.Day11;

public class MinDiffInBST {

    int ans = Integer.MAX_VALUE;
    TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    void dfs(TreeNode root) {
        if (root == null) return;
        dfs(root.left);
        if (prev != null) {
            ans = Math.min(ans, Math.abs(prev.val - root.val));
        }
        prev = root;
        dfs(root.right);
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(48);
        TreeNode node3 = new TreeNode(0);
        TreeNode node4 = new TreeNode(12);
        TreeNode node5 = new TreeNode(49);
        node1.left = node3;
        node1.right = node2;
        node2.left = node4;
        node2.right = node5;
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