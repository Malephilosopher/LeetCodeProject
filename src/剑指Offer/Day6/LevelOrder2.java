package 剑指Offer.Day6;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder2 {

    //dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    void dfs(TreeNode root,int dep, List<List<Integer>> ans){
        if(root == null)return;
        if(dep>=ans.size()) { //如果深度大于目前遍历到的深度
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            ans.add(list);
        }else {
            ans.get(dep).add(root.val);
        }
        dfs(root.left,dep + 1,ans);
        dfs(root.right,dep + 1,ans);
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        if(root == null) return list;
        treeNodeDeque.offer(root);

        while (!treeNodeDeque.isEmpty()){
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < treeNodeDeque.size(); i++) {
                TreeNode node = treeNodeDeque.poll();
                level.add(node.val);
                if(node.left != null) treeNodeDeque.offer(node.left);
                if(node.right != null) treeNodeDeque.offer(node.right);
            }
            list.add(level);
        }

        return list;
    }


}
