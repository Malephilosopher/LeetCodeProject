package WeekCompetition.Week_292;

public class P2 {

    int ans;
    public int averageOfSubtree(TreeNode root) {
        ans = 0;
        dfs(root);
        return ans;
    }

    public int[] dfs(TreeNode root){
        if(root == null)return new int[]{0, 0};
        if(root.left == null && root.right == null){
            ans++;
            return new int[]{root.val, 1};
        }

        int[] leftSum = dfs(root.left);
        int[] rightSum = dfs(root.right);
        int sum = leftSum[0] + rightSum[0] + root.val;
        int count = leftSum[1] + rightSum[1] + 1;
        if(root.val == Math.floor(sum / count)){
            ans++;
        }
        return new int[]{sum, count};
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