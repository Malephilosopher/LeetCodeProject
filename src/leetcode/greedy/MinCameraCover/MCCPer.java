package leetcode.greedy.MinCameraCover;

public class MCCPer {

    private int cameraCount = 0;

    public int minCameraCover(TreeNode root) {
        if(traversal(root) == 0){
            cameraCount++;
        }
        return cameraCount;
    }

    public int traversal(TreeNode cur){
        if(cur == null){
            return 2;
        }

        int left = traversal(cur.left);
        int right = traversal(cur.right);

        if(left == 2 && right == 2){
            return 0;
        }else if(left == 0 || right == 0){
            cameraCount++;
            return 1;
        }else if(left == 1 || right == 1){
            return 2;
        }

        return 0;
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