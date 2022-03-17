package 剑指Offer.Day15;

import java.util.ArrayList;
import java.util.List;

public class PathSum {

    List<List<Integer>> ans;

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(root, target, path);
        return ans;
    }

    public void dfs(TreeNode node, int target, List<Integer> path){
        if(node == null) return;
        path.add(node.val);
        target -= node.val;
        if(node.left == null && node.right == null && target == 0){
            ans.add(new ArrayList<>(path));
        }
        dfs(node.left, target, path);
        dfs(node.right, target, path);
        if(path.size() >= 1){
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

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