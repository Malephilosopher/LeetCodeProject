package leetcode.BinaryTree.InsertIntoBST;

public class IIBPer {

    private TreeNode parent;

    public TreeNode insertIntoBST(TreeNode root, int val) {
        parent = new TreeNode(0);
        if(root == null) root = new TreeNode(val);
        traversal(root, val);
        return root;
    }

    public void traversal(TreeNode node, int val){
        if(node == null){
            TreeNode n = new TreeNode(val);
            if(val < parent.val) parent.left = n;
            else parent.right = n;
            return;
        }
        parent = node;
        if(val < node.val)
        {
            traversal(node.left, val);
        }
        else if(val > node.val)
        {
            traversal(node.right, val);
        }
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