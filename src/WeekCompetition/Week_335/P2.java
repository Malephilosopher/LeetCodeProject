package WeekCompetition.Week_335;

import java.util.*;

public class P2 {

    //https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree/description/

    public class TreeNode {
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

    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> sums = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root == null) return -1;

        queue.offer(root);


        while (!queue.isEmpty()){

            int size = queue.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null)queue.offer(node.left);
                if(node.right != null)queue.offer(node.right);
            }
            sums.add(sum);
        }
        if(sums.size() < k) return -1;
        Collections.sort(sums);
        return sums.get(sums.size() - 1 - k + 1);
    }
}
