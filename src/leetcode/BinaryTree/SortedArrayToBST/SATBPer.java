package leetcode.BinaryTree.SortedArrayToBST;

public class SATBPer {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = traversal(nums,0, nums.length - 1);
        return root;
    }

    public TreeNode traversal(int[] nums, int left, int right){
        if(left > right) return null;
        int mid = left + ((right - left) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        TreeNode l = traversal(nums, left, mid - 1);
        TreeNode r = traversal(nums, mid + 1, right);
        root.left = l;
        root.right = r;
        return root;
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