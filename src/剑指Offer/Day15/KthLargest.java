package 剑指Offer.Day15;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class KthLargest {

    Deque<Integer> queue;

    public int kthLargest(TreeNode root, int k) {
        queue = new LinkedList<>();
        if(root == null) return 0;
        dfs(root, k);
        return queue.peek();
    }

    public void dfs(TreeNode root, int k){
        if(root == null) return;

        dfs(root.left, k);
        if(queue.size() < k){
            queue.add(root.val);
        }else {
            if(root.val > queue.peek()){
                queue.poll();
                queue.offer(root.val);
            }
        }
        dfs(root.right, k);
    }


    int res, k;
    public int kthLargest1(TreeNode root, int k) {
        this.k = k;
        dfs1(root);
        return res;
    }
    void dfs1(TreeNode root) {
        if(root == null) return;
        dfs1(root.right);
        if(k == 0) return;
        if(--k == 0) res = root.val;
        dfs1(root.left);
    }


}

