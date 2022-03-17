package leetcode.BinaryTree.BSTIterator;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {

    private int index;
    private List<Integer> arr;

    public BSTIterator(TreeNode root) {
        index = 0;
        arr = new ArrayList<>();
        inorderTraversal(root, arr);
    }

    private void inorderTraversal(TreeNode root, List<Integer> arr) {
        if(root == null){
            return;
        }
        inorderTraversal(root.left, arr);
        arr.add(root.val);
        inorderTraversal(root.right, arr);
    }

    public int next() {
        return arr.get(index++);
    }

    public boolean hasNext() {
        return index < arr.size();
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