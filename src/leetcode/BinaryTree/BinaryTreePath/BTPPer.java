package BinaryTreePath;

import java.util.ArrayList;
import java.util.List;

public class BTPPer {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) return result;
        traversal(root, path, result);
        return result;
    }

    public void traversal(TreeNode cur, List<Integer> path, List<String> result){
        path.add(cur.val);

        if(cur.left == null && cur.right == null){
            StringBuilder sPath = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                sPath.append(path.get(i));
                sPath.append("->");
            }
            sPath.append(path.get(path.size() - 1));
            result.add(sPath.toString());
            return;
        }

        if(cur.left != null)
        {
            traversal(cur.left, path, result);
            path.remove(path.size() - 1);
        }
        if(cur.right != null)
        {
            traversal(cur.right, path, result);
            path.remove(path.size() - 1);
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