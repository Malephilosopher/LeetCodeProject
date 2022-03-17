package 剑指Offer.Day6;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class LevelOrder3 {

    //dfs
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    public void dfs(TreeNode node, int depth, List<List<Integer>> list){
        if(node == null) return;
        if(depth >= list.size()){
            List<Integer> l = new ArrayList<>();
            l.add(node.val);
            list.add(l);
        }else {
            if((depth & 1) == 1){
                list.get(depth).add(0, node.val);
            }else {
                list.get(depth).add(node.val);
            }
        }
        dfs(node.left, depth + 1, list);
        dfs(node.right, depth + 1, list);
    }

    //bfs
    public List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> treeNodeDeque = new LinkedList<>();
        if(root == null) return list;
        treeNodeDeque.offer(root);

        while (!treeNodeDeque.isEmpty()){
            LinkedList<Integer> level = new LinkedList<>();//LinkedList可以当双端队列用
            int size = treeNodeDeque.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = treeNodeDeque.poll();
                if((list.size() & 1) == 0){ //判断层数奇偶
                    level.addLast(node.val);
                }else {
                    level.addFirst(node.val);
                }
                if(node.left != null) treeNodeDeque.offer(node.left);
                if(node.right != null) treeNodeDeque.offer(node.right);
            }
            list.add(level);
        }

        return list;
    }
}
