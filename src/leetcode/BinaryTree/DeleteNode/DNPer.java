package leetcode.BinaryTree.DeleteNode;

public class DNPer {


    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(root.val == key)
        {
            if (root.left == null) return root.right;
            else if(root.right == null) return root.left;
            else {
                TreeNode cur = root.right;
                while (cur.left != null){
                    cur = cur.left;
                }
                cur.left =  root.left;
                root = root.right;
                return root;
            }
        }
        if(root.val > key) root.left = deleteNode(root.left, key);
        if(root.val < key) root.right = deleteNode(root.right, key);

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