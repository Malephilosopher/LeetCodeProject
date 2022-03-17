package leetcode.BinaryTree.BSTIterator;

import java.util.Deque;
import java.util.LinkedList;

public class BSTIterator1 {

    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator1(TreeNode root) {
        cur = root;
        stack = new LinkedList<>();
    }

    public int next() {
        while (cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
