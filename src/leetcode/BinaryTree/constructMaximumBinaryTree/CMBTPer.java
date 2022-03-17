package leetcode.BinaryTree.constructMaximumBinaryTree;

import java.util.Arrays;

public class CMBTPer {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length == 0) return null;
        if(nums.length == 1) return new TreeNode(nums[0]);
        int max = Integer.MIN_VALUE;
        int maxIndex = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(nums[i] >= max)
            {
                max = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(max);
        root.left = constructMaximumBinaryTree(Arrays.copyOfRange(nums, 0, maxIndex));
        root.right = constructMaximumBinaryTree(Arrays.copyOfRange(nums, maxIndex + 1, n));
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