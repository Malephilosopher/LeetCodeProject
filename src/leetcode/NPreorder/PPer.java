package leetcode.NPreorder;

import java.util.ArrayList;
import java.util.List;

public class PPer {

    List<Integer> ans;

    public List<Integer> preorder(Node root) {
        ans = new ArrayList<>();
        dfs(root);
        return ans;
    }

    public void dfs(Node root){
        if(root == null) return;

        ans.add(root.val);
        for (Node c : root.children) {
            dfs(c);
        }

    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}