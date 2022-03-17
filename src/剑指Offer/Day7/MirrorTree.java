package 剑指Offer.Day7;

import java.util.Deque;
import java.util.LinkedList;

public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        recursion(root);
        return root;
    }

    public void recursion(TreeNode root){
        if(root == null) return;
        if(root.right != null || root.left != null){
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = temp;
        }
        recursion(root.left);
        recursion(root.right);
    }
}
