package leetcode.BinaryTree.FindMode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FMPer {

    private Map<Integer, Integer> dict = new HashMap<>();

    public int[] findMode(TreeNode root) {
        if(root == null) return null;
        traversal(root);
        int max = 0;
        for (int key: dict.keySet()) {
            int freq = dict.get(key);
            max = Math.max(max, freq);
        }
        List<Integer> ans = new ArrayList<>();
        for (int key: dict.keySet()) {
            if(dict.get(key) == max)
            {
                ans.add(key);
            }
        }
        int[] a = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            a[i] = ans.get(i);
        }
        return a;
    }

    public void traversal(TreeNode root)
    {
        if(root == null) return;
        traversal(root.left);
        if(!dict.containsKey(root.val)){
            dict.put(root.val, 1);
        }else {
            dict.put(root.val, dict.get(root.val) + 1);
        }
        traversal(root.right);
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