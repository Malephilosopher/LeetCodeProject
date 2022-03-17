package leetcode.BinaryTree.CountNodes;

public class CNOff {

    public int getNodesNum(TreeNode cur) {
        if (cur == null) return 0;
        int leftNum = getNodesNum(cur.left);      // 左
        int rightNum = getNodesNum(cur.right);    // 右
        int treeNum = leftNum + rightNum + 1;      // 中
        return treeNum;
    }
    public int countNodes(TreeNode root) {
        return getNodesNum(root);
    }
}
